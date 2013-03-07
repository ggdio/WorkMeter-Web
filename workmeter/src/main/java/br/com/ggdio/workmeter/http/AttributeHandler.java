package br.com.ggdio.workmeter.http;

/**
 * Interface for attribute handling on contexts
 * @author Guilherme Dio
 *
 */
public interface AttributeHandler
{
	public void addAttribute(Attribute attribute);
	public Attribute getAttribute(String identifier);
	public void removeAttribute(Attribute attribute);
	public Boolean hasAttribute(String identifier);
}
