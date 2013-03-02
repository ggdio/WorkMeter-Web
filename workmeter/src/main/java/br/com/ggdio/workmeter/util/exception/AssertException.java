package br.com.ggdio.workmeter.util.exception;

/**
 * RuntimeException for assertion handling
 * @author Guilherme Dio
 *
 */
public class AssertException extends RuntimeException 
{
	/**
	 * Generated SerialUID
	 */
	private static final long serialVersionUID = 8551600486557723651L;

	public AssertException(String msg)
	{
		super(msg);
	}

	public AssertException(Throwable cause)
	{
		super(cause);
	}
	
	public AssertException(String msg,Throwable cause)
	{
		super(msg, cause);
	}
}
