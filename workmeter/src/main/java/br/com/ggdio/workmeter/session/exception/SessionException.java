package br.com.ggdio.workmeter.session.exception;

public class SessionException extends RuntimeException 
{
	/**
	 * Generated SerialUID
	 */
	private static final long serialVersionUID = 5844135403809720577L;
	
	public SessionException(String msg)
	{
		super(msg);
	}

	public SessionException(Throwable cause)
	{
		super(cause);
	}
	
	public SessionException(String msg,Throwable cause)
	{
		super(msg, cause);
	}
}
