package br.com.ggdio.workmeter.exception;

public class AppException extends RuntimeException
{

	/**
	 * Generated SerialUID
	 */
	private static final long serialVersionUID = -8458476647103284485L;
	
	public AppException(String msg)
	{
		super(msg);
	}

	public AppException(Throwable cause)
	{
		super(cause);
	}
	
	public AppException(String msg,Throwable cause)
	{
		super(msg, cause);
	}
}
