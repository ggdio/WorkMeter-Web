package br.com.ggdio.workmeter.controller;

import org.apache.log4j.Logger;

import br.com.ggdio.workmeter.service.MasterService;
import br.com.ggdio.workmeter.view.ViewHandler;

/**
 * The Master Controller
 * @author Guilherme Dio
 *
 * @param <T> - Type of the entity to be used
 */
public abstract class MasterController<T> implements ViewHandler
{
	/**
	 * Logger
	 */
	public static final Logger log = Logger.getLogger(MasterController.class.getName());
	
	/**
	 * Service default
	 */
	protected final MasterService<T> service;
	
	/**
	 * Constructs the Master Controller with an service that must be injected
	 * @param service
	 */
	public MasterController(MasterService<T> service)
	{
		this.service = service;
	}
	
	/**
	 * Insere uma entidade
	 * @param entidade
	 */
	protected void adicionar(T entidade)
	{
		getService().add(entidade);
	}
	
	/**
	 * Altera uma entidade
	 * @param entidade
	 */
	protected void alterar(T entidade)
	{
		getService().alter(entidade);
	}
	
	/**
	 * Remove uma entidade
	 * @param entidade
	 */
	protected void remover(T entidade)
	{
		getService().remove(entidade);
	}
	
	@Override
	public String getBase()
	{
		return "";
	}
	
	@Override
	public String getView(String view)
	{
		return getBase()+view;
	}
	
	/**
	 * Retorna o service sendo utilizado
	 * @return
	 */
	protected MasterService<T> getService() 
	{
		return this.service;
	}
}
