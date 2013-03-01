package br.com.ggdio.workmeter.dao;

import org.hibernate.SessionFactory;

/**
 * The default implementation of {@link MasterDao}
 * @author Guilherme Dio
 *
 * @param <T> - The type of the entity
 */
public abstract class DefaultDao<T> extends MasterDao<T>
{
	/**
	 * The main constructor
	 * @param sessionFactory - It must be injected by above level
	 */
	public DefaultDao(SessionFactory sessionFactory) 
	{
		super(sessionFactory);
	}
}
