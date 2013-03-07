package br.com.ggdio.workmeter.http;

import javax.servlet.http.HttpServletRequest;

/**
 * Util class for handling requests
 * @author Guilherme Dio
 *
 */
public class RequestUtil implements AttributeHandler
{
	private final HttpServletRequest request;
	
	public RequestUtil(HttpServletRequest request)
	{
		this.request = request;
	}
	
	public void addAttribute(Attribute attribute)
	{
		request.setAttribute(attribute.getIdentifier(), attribute.getValue());
	}
	
	public Attribute getAttribute(String identifier)
	{
		return new Attribute(identifier,request.getAttribute(identifier));
	}
	
	public void removeAttribute(Attribute attribute)
	{
		request.removeAttribute(attribute.getIdentifier());
	}
	
	public Boolean hasAttribute(String identifier)
	{
		return request.getAttribute(identifier) != null;
	}
}
