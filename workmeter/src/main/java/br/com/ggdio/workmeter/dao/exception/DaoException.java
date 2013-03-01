package br.com.ggdio.workmeter.dao.exception;

/**
 * Exception for handling DAO
 * @author Guilherme Dio
 *
 */
public class DaoException extends Exception 
{
	/**
	 * Generated SerialUID
	 */
	private static final long serialVersionUID = 5844135403809720577L;
	
	public DaoException(String msg,Throwable cause)
	{
		super(msg, cause);
	}
	
	public DaoException(String msg)
	{
		super(msg);
	}
}
