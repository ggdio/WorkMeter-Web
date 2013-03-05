package br.com.ggdio.workmeter.controller.response;

import java.io.Serializable;

/**
 * Handle responses to the front end
 * @author Guilherme Dio
 *
 * @param <T> The type of information
 */
public class Response<T> implements Serializable
{
	/**
	 * Generated SerialUID
	 */
	private static final long serialVersionUID = 8852573722142351353L;
	
	public static final String SUCCESS = "SUCCESS";
	public static final String WARNING = "WARNING";
	public static final String ERROR = "ERROR";
	
	private String message;
	private String status;
	private T information;
	
	public Response(){}
	
	public Response(String status,String message,T information)
	{
		setStatus(status);
		setMessage(message);
		setInformation(information);
	}
	
	public Response(String status,String message)
	{
		this(status, message, null);
	}
	
	public Response(String status)
	{
		this(status, "Response from server", null);
	}
	
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	public T getInformation()
	{
		return information;
	}
	public void setInformation(T information)
	{
		this.information = information;
	}
}
