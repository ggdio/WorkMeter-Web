package br.com.ggdio.workmeter.http;

/**
 * Utilitario para a classe SessionUtil
 * @author guilherme
 *
 */
public class Attribute 
{
	private final String identifier;
	private final Object value;
	
	public Attribute(String identifier, Object value)
	{
		super();
		this.identifier = identifier;
		this.value = value;
	}
	
	public String getIdentifier() 
	{
		return identifier;
	}
	
	public Object getValue() 
	{
		return value;
	}
}
