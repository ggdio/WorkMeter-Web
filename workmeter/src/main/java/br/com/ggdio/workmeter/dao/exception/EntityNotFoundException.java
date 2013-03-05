package br.com.ggdio.workmeter.dao.exception;

/**
 * Exception for entity not found handling
 * @author guilherme
 *
 */
public class EntityNotFoundException extends DaoException 
{
	/**
	 * Generated SerialUID
	 */
	private static final long serialVersionUID = -1763139162120303223L;
	
	public EntityNotFoundException(String msg)
	{
		super(msg);
	}

	public EntityNotFoundException(Throwable cause)
	{
		super(cause);
	}
	
	public EntityNotFoundException(String msg,Throwable cause)
	{
		super(msg, cause);
	}
}
