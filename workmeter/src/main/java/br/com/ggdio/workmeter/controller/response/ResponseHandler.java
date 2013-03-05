<<<<<<< HEAD
package br.com.ggdio.workmeter.controller.response;

import javax.servlet.http.HttpServletRequest;

/**
 * Interface for response implementation
 * @author Guilherme Dio
 *
 */
public interface ResponseHandler 
{
	/**
	 * Prepare the response to the front end
	 * @param request - The request made by fron end
	 * @param response - The response to be sent
	 * @param dispatcher - The respone dispatcher
	 * @param identifier - The {@link String} wich will identify the response on the the attributes
	 */
	public void prepareForward(HttpServletRequest request,Response<?> response,ResponseDispatcher dispatcher,String identifier,String destine);
	
	/**
	 * Prepare the response to the front end
	 * @param request - The request made by fron end
	 * @param response - The response to be sent
	 * @param dispatcher - The respone dispatcher
	 * @param identifier - The {@link String} wich will identify the response on the the attributes
	 */
	public void prepareRedirect(HttpServletRequest request,Response<?> response,ResponseDispatcher dispatcher,String identifier,String destine);
}
=======
package br.com.ggdio.workmeter.controller.response;

import javax.servlet.http.HttpServletRequest;

/**
 * Interface for response implementation
 * @author Guilherme Dio
 *
 */
public interface ResponseHandler 
{
	/**
	 * Prepare the response to the front end
	 * @param request - The request made by fron end
	 * @param response - The response to be sent
	 * @param dispatcher - The respone dispatcher
	 * @param identifier - The {@link String} wich will identify the response on the the attributes
	 */
	public void prepareForward(HttpServletRequest request,Response<?> response,ResponseDispatcher dispatcher,String identifier);
	
	/**
	 * Prepare the response to the front end
	 * @param request - The request made by fron end
	 * @param response - The response to be sent
	 * @param dispatcher - The respone dispatcher
	 * @param identifier - The {@link String} wich will identify the response on the the attributes
	 */
	public void prepareRedirect(HttpServletRequest request,Response<?> response,ResponseDispatcher dispatcher,String identifier);
}
>>>>>>> 8ef73d3a5d1f09a7795a111918af323948442114
