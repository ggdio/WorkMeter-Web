package br.com.ggdio.workmeter.util;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import br.com.ggdio.workmeter.util.exception.MessagerInitializationException;

/**
 * Util class for retrieving messages from an multi language resource bundle archive
 * @author Guilherme Dio
 *
 */
public final class Messager
{
	/**
	 * Logger
	 */
	private final Logger log = Logger.getLogger(Messager.class);
	
	/**
	 * The resource bundle of messages
	 */
	private final ResourceBundle bundle;
	
	/**
	 * Assert for code validation
	 */
	private final Assert assertion = new Assert(log);
	
	/**
	 * Constructs a {@link Messager} with a base name of {@link ResourceBundle}
	 * for retrieving messages
	 * @param baseName - The base name of the I18n messages
	 */
	public Messager(String baseName) 
	{
		assertion.setExceptionType(MessagerInitializationException.class);
		assertion.notEmpty(baseName);
		bundle = ResourceBundle.getBundle(baseName);
	}
	
	/**
	 * Retrieves a message from the resource bundle
	 * @param key - The key to the message
	 * @return Message
	 */
	public String getMessage(String key)
	{
		assertion.setExceptionType(MessagerInitializationException.class);
		assertion.notEmpty(key);
		return bundle.getString(key);
	}
}
