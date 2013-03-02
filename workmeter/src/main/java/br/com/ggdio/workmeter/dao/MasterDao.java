package br.com.ggdio.workmeter.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.core.GenericTypeResolver;

import br.com.ggdio.workmeter.dao.exception.DaoException;
import br.com.ggdio.workmeter.dao.exception.DaoInitializationException;
import br.com.ggdio.workmeter.dao.exception.EntityNotFoundException;
import br.com.ggdio.workmeter.util.Assert;

/**
 * The Master DAO
 * @author Guilherme Dio
 * 
 * @param <T> - Type of the entity for persistence
 */
public abstract class MasterDao<T>
{
	/**
	 * Logger
	 */
	protected final Logger log = Logger.getLogger(MasterDao.class);
	
	/**
	 * The sessionFactory is immutable and must be injected by the above
	 */
	private final SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	/**
	 * The class type is populated by evaluating the T parameter
	 */
	private final Class<T> clazzType;
	
	/**
	 * Assertion handler
	 */
	private final Assert assertion = new Assert(log);
	
	/**
	 * Contructs the MasterDao with a SessionFactory
	 * @param sessionFactory - The sessionFactory dependency
	 * @throws DaoInitializationException - if the sessionFactory is empty
	 */
	@SuppressWarnings("unchecked")
	public MasterDao(SessionFactory sessionFactory)
	{
		assertion.setExceptionType(DaoInitializationException.class);
		assertion.notNull(sessionFactory);
		this.sessionFactory = sessionFactory;
		this.clazzType = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), MasterDao.class);
		assertion.setExceptionType(DaoException.class);
	}
	
	/**
	 * Saves or Updates the current entity on the database
	 * @param entity - The entity to be persisted
	 */
	public void saveOrUpdate(T entity)
	{
		assertion.notNull(entity);
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
			String msg = "The save/update of entity '"+entity.getClass().getSimpleName()+"' caused an exception";
			log.error(msg,e);
			error = e;
		}
		finally
		{
			close();
		}
		if(error != null) throw new DaoException(error);
	}
	
	/**
	 * Removes the entity of the database
	 * @param entity - The entity to be removed
	 */
	public void delete(T entity)
	{
		assertion.notNull(entity);
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
			String msg = "The delete of entity '"+entity.getClass().getSimpleName()+"' caused an exception";
			log.error(msg,e);
			error = e;
		}
		finally
		{
			close();
		}
		if(error != null) throw new DaoException(error);
	}
	
	/**
	 * Retrieves an entity by its id
	 * @param identifier - identifier of the current entity
	 * @return An entity found by the identifier
	 */
	@SuppressWarnings("unchecked")
	public T get(Serializable identifier)
	{
		assertion.notNull(identifier);
		T entity = null;
		Exception error = null;
		try
		{
			begin();
			entity = (T) getSession().get(clazzType, identifier);
			if(entity == null)
				error = new EntityNotFoundException("Unnable to find the entity '"+clazzType.getSimpleName()+"' with an ID equals to '"+identifier+"'");
			commit();
		}
		catch(Exception e)
		{
			rollback();
			String msg = "The delete of entity '"+entity.getClass().getSimpleName()+"' caused an exception";
			log.error(msg,e);
			error = e;
		}
		finally
		{
			close();
		}
		if(error != null) throw new DaoException(error);
		return entity;
	}
	
	/**
	 * Identify all the occurencies of the current entity on the database, limited by a first result index and the max results to be collected
	 * @param firstResult - The first row index
	 * @param maxResults - Maximum number of rows to be collected
	 * @return List of values of the current entity
	 */
	@SuppressWarnings("unchecked")
	public List<T> listAll(Integer firstResult,Integer maxResults)
	{
		assertion.notNull(firstResult);
		assertion.notNull(maxResults);
		Exception error = null;
		List<T> entities = null;
		try
		{
			begin();
			Criteria criteria = getSession().createCriteria(clazzType);
			if(firstResult > 0)
				criteria.setFirstResult(firstResult);
			if(maxResults > 0)
				criteria.setMaxResults(maxResults);
			entities = criteria.list();
			commit();
		}
		catch(Exception e)
		{
			rollback();
			String msg = "An error occured while listing the entity '"+clazzType.getSimpleName()+"'";
			log.error(msg,e);
			error = e;
		}
		finally
		{
			close();
		}
		if(error != null) throw new DaoException(error);
		return entities;
	}
	
	/**
	 * Identify all the occurencies of the current entity on the database, limited a max number of results to be collected
	 * @param maxResults - Maximum number of rows to be collected
	 * @return List of values of the current entity
	 */
	public List<T> listAll(Integer maxResults)
	{
		assertion.notNull(maxResults);
		return listAll(0,maxResults);
	}
	
	/**
	 * Collect all the occurencies of the entity on the database
	 * @return List of values of the current entity
	 */
	public List<T> listAll()
	{
		return listAll(0);
	}	
	
	/**
	 * Execute hql query on the database
	 * @param hql - The query to be executed
	 * @param firstResult - The first row index
	 * @param maxResults - Maximum number of rows to be collected
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> hqlQuery(String hql,Integer firstResult,Integer maxResults)
	{
		assertion.notEmpty(hql);
		assertion.notNull(firstResult);
		assertion.notNull(maxResults);
		Exception error = null;
		List<T> entities = null;
		try
		{
			begin();
			Query query = getSession().createQuery(hql);
			if(firstResult > 0)
				query.setFirstResult(firstResult);
			if(maxResults > 0)
				query.setMaxResults(maxResults);
			query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			entities = query.list();
			commit();
		}
		catch(Exception e)
		{
			rollback();
			String msg = "An error occured while executing the following HQL: '"+hql+"' with an row limit of '"+maxResults+"' and first result '"+firstResult+"'";
			log.error(msg,e);
			error = e;
		}
		finally
		{
			close();
		}
		if(error != null) throw new DaoException(error);
		return entities;
	}
	
	/**
	 * Execute hql query on the database
	 * @param hql - The query to be executed
	 * @param maxResults - Maximum number of rows to be collected
	 * @return
	 */
	public List<T> hqlQuery(String hql,Integer maxResults)
	{
		assertion.notNull(hql);
		assertion.notNull(maxResults);
		return hqlQuery(hql,0,maxResults);
	}
	
	/**
	 * Execute hql query on the database
	 * @param hql - The query to be executed
	 * @return
	 */
	public List<T> hqlQuery(String hql)
	{
		assertion.notNull(hql);
		return hqlQuery(hql,0);
	}
	
	/**
	 * Initialize the session and the transaction
	 */
	protected void begin()
	{
		if(!isSessionOpen() && !isTransactionActive())
		{
			try
			{
				setSession(getSessionFactory().openSession());
				setTransaction(getSession().beginTransaction());
			}
			catch(HibernateException e)
			{
				log.warn("Couldn't open the session and begin the transaction",e);
			}
		}
	}
	
	/**
	 * Close the current session
	 */
	protected void close()
	{
		if(getSession() != null)
		{
			try
			{
				getSession().clear();
				getSession().close();
			}
			catch(HibernateException e)
			{
				log.warn("Couldn't close the current session",e);
			}
		}
	}
	
	/**
	 * Execute commit operation
	 */
	protected void commit()
	{
		if(getTransaction() != null)
		{
			try
			{
				getTransaction().commit();
			}
			catch(HibernateException e)
			{
				log.warn("Couldn't commit the current transaction",e);
			}
		}
	}
	
	/**
	 * Execute rollback operation
	 */
	protected void rollback()
	{
		if(getTransaction() != null)
		{
			try
			{
				getTransaction().rollback();
			}
			catch(HibernateException e)
			{
				log.warn("Couldn't rollback the current transaction",e);
			}
		}
	}
	
	/**
	 * Gets the hibernate's session used
	 * @return A new session
	 */
	protected Session getSession()
	{
		return this.session;
	}
	
	/**
	 * Sets the current hibernate's session to be used
	 * @param session
	 */
	protected void setSession(Session session)
	{
		assertion.notNull(session);
		this.session = session;
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
		if(getSession() == null) 
			return false;
		return getSession().isOpen();
	}
	
	/**
	 * Sets the hibernate's transaction
	 * @param transaction
	 */
	protected void setTransaction(Transaction transaction) 
	{
		assertion.notNull(transaction);
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
	 * 		<p>False - if its not active
	 */
	protected Boolean isTransactionActive()
	{
		if(getTransaction() == null) 
			return false;
		return getTransaction().isActive();
	}
	
	/**
	 * Recover the entity class type
	 * @return Class of the entity
	 */
	public Class<T> getClazzType() 
	{
		return clazzType;
	}
}
