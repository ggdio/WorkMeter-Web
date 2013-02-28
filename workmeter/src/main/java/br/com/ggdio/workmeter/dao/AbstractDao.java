package br.com.ggdio.workmeter.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Repository;

/**
 * Abstract DAO
 * @author Guilherme Dio
 *
 * @param <T> - Tipo da entidade
 */

@Repository("abstractDao")
public abstract class AbstractDao<T>
{
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	private final Class<T> clazzType;
	
	@SuppressWarnings("unchecked")
	public AbstractDao() 
	{
		 this.clazzType = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), AbstractDao.class);
	}
	
	public T saveOrUpdate(T model)
	{
		try 
		{
			begin();
			getSession().saveOrUpdate(model);
			commit();
		}
		catch (Exception e) 
		{
			rollback();
			log.error("Save or Update de "+model.toString(),e);
		}
		finally
		{
			close();
		}
		return model;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listAll()
	{
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
		}
		finally
		{
			close();
		}
		return list;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSession()
	{
		return this.session;
	}
	
	protected void begin()
	{
		if(!this.session.isOpen() && !this.transaction.isActive())
		{
			this.session = getSession();
			this.transaction = this.session.beginTransaction();
		}
	}
	
	protected void commit()
	{
		if(this.transaction != null)
			transaction.commit();
	}
	
	protected void rollback()
	{
		if(this.transaction != null)
			transaction.rollback();
	}
	
	protected void close()
	{
		if(this.session != null)
			session.close();
	}
}
