package br.com.ggdio.workmeter.service;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.ggdio.workmeter.controller.MasterController;
import br.com.ggdio.workmeter.dao.MasterDao;
import br.com.ggdio.workmeter.dao.exception.DaoException;
import br.com.ggdio.workmeter.service.exception.ServiceException;

/**
 * The Master Service
 * @author Guilherme Dio
 *
 * @param <T> - Type of the entity to be used
 */
public abstract class MasterService<T>
{
	/**
	 * Logger
	 */
	protected final Logger log = Logger.getLogger(MasterController.class);
	
	/**
	 * The dao must be injected by the above level
	 */
	private final MasterDao<T> dao;
	
	/**
	 * Constructs the master service with a dao that must be injected
	 * @param dao - The dao to be used
	 */
	public MasterService(MasterDao<T> dao) 
	{
		this.dao = dao;
	}
	
	/**
	 * Execute the add statement of the entity on the model
	 * @param entity - The entity to be added
	 */
	public void add(T entity)
	{
		try
		{
			dao.saveOrUpdate(entity);
		}
		catch(DaoException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			String msg = "An unexpected error has occurred while adding the entity '"+entity.getClass().getSimpleName()+"'";
			throw new ServiceException(msg,e);
		}
	}
	
	/**
	 * Execute the alter/update statement on the entity of the model
	 * @param entity - The entity to be modified
	 */
	public void alter(T entity)
	{
		try
		{
			dao.saveOrUpdate(entity);
		}
		catch(DaoException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			String msg = "An unexpected error has occurred while trying to alter the entity '"+entity.getClass().getSimpleName()+"'";
			throw new ServiceException(msg,e);
		}
	}
	
	/**
	 * Execute the remove statement on the entity of the model
	 * @param entity - The entity to be removed
	 */
	public void delete(T entity)
	{
		try
		{
			dao.delete(entity);
		}
		catch(DaoException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			String msg = "An unexpected error has occurred while deleting the entity '"+entity.getClass().getSimpleName()+"'";
			throw new ServiceException(msg,e);
		}
	}
	
	/**
	 * Execute the get statement using the identifier to find the entity on the model
	 * @param identifier
	 * @return The entity found
	 */
	public T get(Serializable identifier)
	{
		T entity;
		try
		{
			entity = dao.get(identifier);
		}
		catch(DaoException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			String msg = "An unexpected error has occurred while getting the entity '"+dao.getClazzType().getSimpleName()+"'";
			throw new ServiceException(msg,e);
		}
		return entity;
	}
	
	/**
	 * Execute the list statement returning a collection of the current entity of the model with a limited number of results and a first entity index to begin collecting
	 * @return List of entities
	 */
	public List<T> listAll(Integer firstResult,Integer maxResults)
	{
		List<T> entities;
		try
		{
			entities = dao.listAll(firstResult,maxResults);
		}
		catch(DaoException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			String msg = "An unexpected error has occurred while listing the values of the entity '"+dao.getClazzType().getSimpleName()+"'";
			throw new ServiceException(msg,e);
		}
		return entities;
	}
	
	/**
	 * Execute the list statement returning a collection of the current entity of the model with a limited number of results
	 * @return List of entities
	 */
	public List<T> listAll(Integer maxResults)
	{
		return listAll(0,maxResults);
	}
	
	/**
	 * Execute the list statement returning a collection of the current entity of the model
	 * @return List of entities
	 */
	public List<T> listAll()
	{
		return listAll(0);
	}
	
	/**
	 * Gets the dao being used
	 * @return The dao used
	 */
	protected MasterDao<T> getDao()
	{
		return this.dao;
	}
}
