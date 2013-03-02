package br.com.ggdio.workmeter.dao.exception;

import br.com.sourcesphere.core.exception.InitializationException;

/**
 * Handle DAO Initialization exception
 * @author guilherme
 *
 */
public class DaoInitializationException extends InitializationException 
{

	/**
	 * Generated SerialUID
	 */
	private static final long serialVersionUID = -5943148129622939502L;

	public DaoInitializationException(String msg) 
	{
		super(msg);
	}

}
