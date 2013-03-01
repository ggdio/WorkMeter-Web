package br.com.ggdio.workmeter.service;

import java.util.List;

import br.com.ggdio.workmeter.dao.MasterDao;

/**
 * The Master Service
 * @author Guilherme Dio
 *
 * @param <T> - Type of the entity to be used
 */
public abstract class MasterService<T>
{
	/**
	 * The dao must be injected by the above level
	 */
	private final MasterDao<T> dao;
	
	/**
	 * Constructs the master service with a dao that must be injected
	 * @param dao
	 */
	public MasterService(MasterDao<T> dao) 
	{
		this.dao = dao;
	}
	
	/**
	 * Execute the add statement of the entity on the model
	 * @param entidade
	 */
	public void add(T entity)
	{
		dao.saveOrUpdate(entity);
	}
	
	/**
	 * Execute the alter/update statement on the entity of the model
	 * @param entidade
	 */
	public void alter(T entity)
	{
		dao.saveOrUpdate(entity);
	}
	
	/**
	 * Execute the remove statement on the entity of the model
	 * @param entidade
	 */
	public void remove(T entity)
	{
		dao.delete(entity);
	}
	
	/**
	 * Execute the list statement returning a collection of the current entity of the model
	 * @return
	 */
	public List<T> list()
	{
		return dao.listAll();
	}
}
