package br.com.ggdio.workmeter.service;

import br.com.ggdio.workmeter.dao.DefaultDao;

/**
 * The default implementation of {@link MasterService}
 * @author Guilherme Dio
 *
 * @param <T> - The type of the entity
 */
public abstract class DefaultService<T> extends MasterService<T> 
{
	/**
	 * The main constructor
	 * @param dao - It must be injected by above level
	 */
	public DefaultService(DefaultDao<T> dao) 
	{
		super(dao);
	}
}
