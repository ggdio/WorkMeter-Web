package br.com.ggdio.workmeter.dao.exception;

/**
 * Exception for handling DAO
 * @author Guilherme Dio
 *
 */
public class DaoException extends RuntimeException 
{
	/**
	 * Generated SerialUID
	 */
	private static final long serialVersionUID = 5844135403809720577L;
	
	public DaoException(String msg)
	{
		super(msg);
	}

	public DaoException(Throwable cause)
	{
		super(cause);
	}
	
	public DaoException(String msg,Throwable cause)
	{
		super(msg, cause);
	}
}
