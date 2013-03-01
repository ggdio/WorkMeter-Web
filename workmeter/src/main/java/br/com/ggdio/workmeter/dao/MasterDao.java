package br.com.ggdio.workmeter.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.core.GenericTypeResolver;

/**
 * The Master DAO
 * @author Guilherme Dio
 * 
 * @param <T> - Tipo da entidade
 */
@SuppressWarnings("unchecked")
public abstract class MasterDao<T>
{
	/**
	 * Logger
	 */
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
	 * The sessionFactory is immutable and must be injected by the above
	 */
	@SuppressWarnings("unused")
	private final SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	/**
	 * The class type is populated by evaluating the T parameter
	 */
	private final Class<T> clazzType;
	
	/**
	 * Contructs the MasterDao with a SessionFactory
	 * @param sessionFactory - The sessionFactory dependency
	 */
	public MasterDao(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
		this.clazzType = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), MasterDao.class);
	}
	
	/**
	 * Saves or Updates the current entity on the database
	 * @param entity
	 * @return
	 */
	public T saveOrUpdate(T entity)
	{
		Exception error = null;
		try 
		{
			begin();
			getSession().saveOrUpdate(entity);
			commit();
		}
		catch (Exception e) 
		{
			rollback();
			log.error("The save/update of entity '"+entity.getClass().getSimpleName()+"' caused an exception",e);
			error = e;
		}
		finally
		{
			close();
		}
		if(error != null) throw new RuntimeException(error);
		return entity;
	}
	
	public void delete(T entity)
	{
		Exception error = null;
		try
		{
			begin();
			getSession().delete(entity);
			commit();
		}
		catch(Exception e)
		{
			rollback();
			log.error("The delete of entity '"+entity.getClass().getSimpleName()+"' caused an exception",e);
			error = e;
		}
		finally
		{
			close();
		}
		if(error != null) throw new RuntimeException(error);
	}
	
	/**
	 * Identify all occurencies of the current entity being used
	 * @return List of the current entity
	 */
	public List<T> listAll()
	{
		Exception error = null;
		List<T> list = null;
		try
		{
			begin();
			Criteria criteria = getSession().createCriteria(clazzType);
			list = criteria.list();
		}
		catch(Exception e)
		{
			rollback();
			log.error("List All "+clazzType.getSimpleName(),e);
			error = e;
		}
		finally
		{
			close();
		}
		if(error != null) throw new RuntimeException(error);
		return list;
	}
	
	/**
	 * Initialize the session and the transaction
	 */
	protected void begin()
	{
		if(!isSessionOpen() && !isTransactionActive())
		{
			setTransaction(getSession().beginTransaction());
		}
	}
	
	/**
	 * Execute commit operation
	 */
	protected void commit()
	{
		if(getTransaction() != null)
			getTransaction().commit();
	}
	
	/**
	 * Execute rollback operation
	 */
	protected void rollback()
	{
		if(getTransaction() != null)
			getTransaction().rollback();
	}
	
	/**
	 * Close the current session
	 */
	protected void close()
	{
		if(getSession() != null)
		{
			getSession().clear();
			getSession().close();
		}
	}
	
	/**
	 * Gets the hibernate's session used
	 * @return A new session
	 */
	protected Session getSession()
	{
		return getSessionFactory().openSession();
	}
	
	/**
	 * Gets the hibernate's session factory used
	 * @return Current SessionFactory
	 */
	protected SessionFactory getSessionFactory()
	{
		return this.sessionFactory;
	}
	
	/**
	 * Identify if the session is opened
	 * @return True - if its opened
	 * 		<p>False - if its closed
	 */
	protected Boolean isSessionOpen()
	{
		if(getSession() == null) return false;
		return getSession().isOpen();
	}
	
	/**
	 * Sets the hibernate's transaction
	 * @param transaction
	 */
	protected void setTransaction(Transaction transaction) 
	{
		this.transaction = transaction;
	}
	
	/**
	 * Gets the hibernate's transaction
	 * @return
	 */
	protected Transaction getTransaction() 
	{
		return transaction;
	}
	
	/**
	 * Identify if the current transaction is active or not
	 * @return True - if its active
	 * 		<p>False - if not
	 */
	protected Boolean isTransactionActive()
	{
		if(getTransaction() == null) return false;
		return getTransaction().isActive();
	}
}
