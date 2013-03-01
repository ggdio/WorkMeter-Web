package br.com.ggdio.workmeter.controller;

import org.apache.log4j.Logger;

import br.com.ggdio.workmeter.service.MasterService;

/**
 * The Master Controller
 * @author Guilherme Dio
 *
 * @param <T> - Type of the entity to be used
 */
public abstract class MasterController<T>
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
	
	/**
	 * Recupera a base de views especifica do controller
	 * @return Base de diretorio das views
	 */
	protected String getBase()
	{
		return "/";
	}
	
	/**
	 * Recupera a view especifica a partir da base de diretorio
	 * @param view - Nome da view(Ex: index.jsp)
	 * @return String
	 */
	protected String getView(String view)
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
