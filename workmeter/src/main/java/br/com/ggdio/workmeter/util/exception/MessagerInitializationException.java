package br.com.ggdio.workmeter.util.exception;

import br.com.ggdio.workmeter.exception.InitializationException;
import br.com.ggdio.workmeter.util.Messager;

/**
 * {@link RuntimeException} for handling initialization errors on {@link Messager}
 * @author guilherme
 *
 */
public class MessagerInitializationException extends InitializationException
{
	/**
	 * Generated SerialUID
	 */
	private static final long serialVersionUID = -6409668841542493587L;
	
	public MessagerInitializationException(String msg)
	{
		super(msg);
	}

	public MessagerInitializationException(Throwable cause)
	{
		super(cause);
	}
	
	public MessagerInitializationException(String msg,Throwable cause)
	{
		super(msg, cause);
	}
}
