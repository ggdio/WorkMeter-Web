<<<<<<< HEAD
package br.com.ggdio.workmeter.controller.response;

import javax.servlet.http.HttpServletRequest;

import br.com.ggdio.workmeter.view.PathHandler;
import br.com.sourcesphere.core.util.StringUtils;

/**
 * Class for dispatching responses(redirect ou forward)
 * @author Guilherme Dio
 *
 */
public final class ResponseDispatcher 
{
	private PathHandler pathHandler;
	private String statement = REDIRECT;
	private String destine = "";
	
	public static final String REDIRECT = "redirect:";
	public static final String FORWARD = "forward:";
	
	public ResponseDispatcher(PathHandler pathHandler) 
	{
		this.pathHandler = pathHandler;
	}
	
	/**
	 * Constructs a {@link String} containing the statement for the dispatch
	 * @param destine - The destine path to be redirected
	 * @return {@link String} containing the command
	 */
	public String generateDispatch(String destine)
	{
		return load();
	}
	
	
	/**
	 * Loads an attribute to the response model
	 * @param model - Spring model to be used as response carrier
	 * @param response - The response to be sent
	 * @param identifier  - The identifier of the attribute on response
	 */
	public void loadResponse(String statement,HttpServletRequest request,Response<?> response,String identifier,String destine)
	{
		if(StringUtils.hasText(statement))
			this.statement = statement;
		request.setAttribute(identifier, response);
		this.destine = destine;
	}
	
	private String load()
	{
		String pathBase = this.statement+pathHandler.getPathBase();
		if(!pathBase.endsWith("/"))
			pathBase += "/";
		return pathBase+destine;
	}
	
	public void changePathHandler(PathHandler pathHandler) 
	{
		this.pathHandler = pathHandler;
	}
	
	@Override
	public String toString() 
	{
		return load();
	}
}
=======
package br.com.ggdio.workmeter.controller.response;

import javax.servlet.http.HttpServletRequest;

import br.com.ggdio.workmeter.view.PathHandler;

/**
 * Class for dispatching responses(redirect ou forward)
 * @author Guilherme Dio
 *
 */
public final class ResponseDispatcher 
{
	private final PathHandler pathHandler;
	
	public ResponseDispatcher(PathHandler pathHandler) 
	{
		this.pathHandler = pathHandler;
	}
	
	/**
	 * Constructs a {@link String} containing the statement to redirect to the specific path
	 * @param destine - The destine path to be redirected
	 * @return {@link String} containing the statemente
	 */
	public String generateRedirectDispatch(String destine)
	{
		return load("redirect:",destine);
	}
	
	/**
	 * Constructs a {@link String} containing the statement to forward to the specific path
	 * @param destine - The destine path to be forwarded
	 * @return {@link String} containing the statemente
	 */
	public String generateForwardDispatch(String destine)
	{
		return load("forward:",destine);
	}
	
	/**
	 * Loads an attribute to the response model
	 * @param model - Spring model to be used as response carrier
	 * @param response - The response to be sent
	 * @param identifier  - The identifier of the attribute on response
	 */
	public void loadResponse(HttpServletRequest request,Response<?> response,String identifier)
	{
		request.setAttribute(identifier, response);
	}
	
	private String load(String statement,String destine)
	{
		String pathBase = statement+pathHandler.getPathBase();
		if(!pathBase.endsWith("/"))
			pathBase += "/";
		return pathBase+destine;
	}
}
>>>>>>> 8ef73d3a5d1f09a7795a111918af323948442114
