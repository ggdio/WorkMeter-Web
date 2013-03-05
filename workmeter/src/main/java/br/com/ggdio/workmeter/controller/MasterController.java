<<<<<<< HEAD
package br.com.ggdio.workmeter.controller;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import br.com.ggdio.workmeter.controller.response.Response;
import br.com.ggdio.workmeter.controller.response.ResponseDispatcher;
import br.com.ggdio.workmeter.service.MasterService;

/**
 * The Master Controller
 * @author Guilherme Dio
 *
 * @param <T> - Type of the entity to be used
 */
public abstract class MasterController<T> extends Controller
{
	/**
	 * Logger
	 */
	protected final Logger log = Logger.getLogger(MasterController.class);
	
	/**
	 * The service to be used
	 */
	protected final MasterService<T> service;
	
	/**
	 * The dispatcher handler for redirecting ou forwarding
	 */
	protected final ResponseDispatcher dispatcher = new ResponseDispatcher(this);
	
	/**
	 * Constructs the Master Controller with an service that must be injected
	 * @param service
	 */
	public MasterController(MasterService<T> service)
	{
		this.service = service;
	}
	
	/**
	 * Add an entity to the system
	 * @param Entity to be added on the system
	 */
	protected void add(T entidade)
	{
		getService().add(entidade);
	}
	
	/**
	 * Modify an entity on the system
	 * @param Entity to be modified on the system
	 */
	protected void alter(T entity)
	{
		getService().alter(entity);
	}
	
	/**
	 * Removes an entity on the system
	 * @param Entity to be deleted from the system
	 */
	protected void delete(T entity)
	{
		getService().delete(entity);
	}
	
	/**
	 * Find an entity by an unique identifier
	 * @param identifier
	 * @return Identified entity
	 */
	protected T get(Serializable identifier)
	{
		return getService().get(identifier);
	}
	
	/**
	 * Identify all the entities with limited number of collection and a first position to look for
	 * @return List of the entity
	 */
	protected List<T> listAll(Integer firstResult,Integer maxResults)
	{
		return getService().listAll(firstResult,maxResults);
	}
	
	/**
	 * Identify all the entities with limited number of collection
	 * @return List of the entity
	 */
	protected List<T> listAll(Integer maxResults)
	{
		return listAll(0,maxResults);
	}
	
	/**
	 * Identify all the entities
	 * @return List of the entity
	 */
	protected List<T> listAll()
	{
		return listAll(0);
	}
	
	/**
	 * Gets the service being used
	 * @return  A business service
	 */
	protected MasterService<T> getService() 
	{
		return this.service;
	}
	
	/**
	 * Prepare the response to the front end
	 * @param request - The request made by fron end
	 * @param response - The response to be sent
	 * @param dispatcher - The respone dispatcher
	 * @param identifier - The {@link String} wich will identify the response on the the attributes
	 */
	public void prepareForward(HttpServletRequest request,Response<?> response,ResponseDispatcher dispatcher,String identifier,String destine)
	{
		dispatcher.loadResponse(ResponseDispatcher.FORWARD,request, response, identifier, destine);
	}
	
	/**
	 * Prepare the response to the front end
	 * @param request - The request made by fron end
	 * @param response - The response to be sent
	 * @param dispatcher - The respone dispatcher
	 * @param identifier - The {@link String} wich will identify the response on the the attributes
	 */
	public void prepareRedirect(HttpServletRequest request,Response<?> response,ResponseDispatcher dispatcher,String identifier,String destine)
	{
		dispatcher.loadResponse(ResponseDispatcher.REDIRECT,request, response, identifier,destine);
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
	
	@Override
	public String getPathBase() 
	{
		return "";
	}
}
=======
package br.com.ggdio.workmeter.controller;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import br.com.ggdio.workmeter.controller.response.Response;
import br.com.ggdio.workmeter.controller.response.ResponseDispatcher;
import br.com.ggdio.workmeter.service.MasterService;

/**
 * The Master Controller
 * @author Guilherme Dio
 *
 * @param <T> - Type of the entity to be used
 */
public abstract class MasterController<T> extends Controller
{
	/**
	 * Logger
	 */
	protected final Logger log = Logger.getLogger(MasterController.class);
	
	/**
	 * The service to be used
	 */
	protected final MasterService<T> service;
	
	/**
	 * The dispatcher handler for redirecting ou forwarding
	 */
	protected final ResponseDispatcher dispatcher = new ResponseDispatcher(this);
	
	/**
	 * Constructs the Master Controller with an service that must be injected
	 * @param service
	 */
	public MasterController(MasterService<T> service)
	{
		this.service = service;
	}
	
	/**
	 * Add an entity to the system
	 * @param Entity to be added on the system
	 */
	protected void add(T entidade)
	{
		getService().add(entidade);
	}
	
	/**
	 * Modify an entity on the system
	 * @param Entity to be modified on the system
	 */
	protected void alter(T entity)
	{
		getService().alter(entity);
	}
	
	/**
	 * Removes an entity on the system
	 * @param Entity to be deleted from the system
	 */
	protected void delete(T entity)
	{
		getService().delete(entity);
	}
	
	/**
	 * Find an entity by an unique identifier
	 * @param identifier
	 * @return Identified entity
	 */
	protected T get(Serializable identifier)
	{
		return getService().get(identifier);
	}
	
	/**
	 * Identify all the entities with limited number of collection and a first position to look for
	 * @return List of the entity
	 */
	protected List<T> listAll(Integer firstResult,Integer maxResults)
	{
		return getService().listAll(firstResult,maxResults);
	}
	
	/**
	 * Identify all the entities with limited number of collection
	 * @return List of the entity
	 */
	protected List<T> listAll(Integer maxResults)
	{
		return listAll(0,maxResults);
	}
	
	/**
	 * Identify all the entities
	 * @return List of the entity
	 */
	protected List<T> listAll()
	{
		return listAll(0);
	}
	
	/**
	 * Gets the service being used
	 * @return  A business service
	 */
	protected MasterService<T> getService() 
	{
		return this.service;
	}
	
	/**
	 * Prepare the response to the front end
	 * @param request - The request made by fron end
	 * @param response - The response to be sent
	 * @param dispatcher - The respone dispatcher
	 * @param identifier - The {@link String} wich will identify the response on the the attributes
	 */
	public void prepareForward(HttpServletRequest request,Response<?> response,ResponseDispatcher dispatcher,String identifier)
	{
		dispatcher.loadResponse(request, response, identifier);
	}
	
	/**
	 * Prepare the response to the front end
	 * @param request - The request made by fron end
	 * @param response - The response to be sent
	 * @param dispatcher - The respone dispatcher
	 * @param identifier - The {@link String} wich will identify the response on the the attributes
	 */
	public void prepareRedirect(HttpServletRequest request,Response<?> response,ResponseDispatcher dispatcher,String identifier)
	{
		dispatcher.loadResponse(request, response, identifier);
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
	
	@Override
	public String getPathBase() 
	{
		return "";
	}
}
>>>>>>> 8ef73d3a5d1f09a7795a111918af323948442114
