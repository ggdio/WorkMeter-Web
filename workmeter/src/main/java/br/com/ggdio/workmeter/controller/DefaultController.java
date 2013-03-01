package br.com.ggdio.workmeter.controller;

import br.com.ggdio.workmeter.service.DefaultService;

/**
 * The default implementation of {@link MasterController}
 * @author Guilherme Dio
 *
 * @param <T> - The type of the entity
 */
public abstract class DefaultController<T> extends MasterController<T> 
{
	/**
	 * The main constructor
	 * @param service - It must be injected by above level
	 */
	public DefaultController(DefaultService<T> service) 
	{
		super(service);
	}
}
