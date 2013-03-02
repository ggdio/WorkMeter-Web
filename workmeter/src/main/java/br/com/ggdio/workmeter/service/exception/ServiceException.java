package br.com.ggdio.workmeter.service.exception;

/**
 * Exception for service handle
 * @author Guilherme Dio
 *
 */
public class ServiceException extends RuntimeException 
{
	/**
	 * Generated SerialUID
	 */
	private static final long serialVersionUID = -8254179395399208297L;

	public ServiceException(String msg)
	{
		super(msg);
	}

	public ServiceException(Throwable cause)
	{
		super(cause);
	}
	
	public ServiceException(String msg,Throwable cause)
	{
		super(msg, cause);
	}
}
