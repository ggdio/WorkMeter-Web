package br.com.ggdio.workmeter.http;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.ggdio.workmeter.model.Usuario;
import br.com.ggdio.workmeter.session.exception.SessionException;

public class SessionUtil implements AttributeHandler
{
	private final HttpSession session;
	
	public SessionUtil(HttpSession sessao)
	{
		this.session = sessao;
	}
	
	public SessionUtil(HttpServletRequest request) 
	{
		this(request.getSession());
	}
	
	public void addAttribute(Attribute attribute)
	{
		this.session.setAttribute(attribute.getIdentifier(), attribute.getValue());
	}
	
	public Attribute getAttribute(String identifier)
	{
		return new Attribute(identifier,this.session.getAttribute(identifier));
	}
	
	public void removeAttribute(Attribute attribute)
	{
		this.session.removeAttribute(attribute.getIdentifier());
	}
	
	public Boolean hasAttribute(String identifier)
	{
		return this.session.getAttribute(identifier) != null;
	}
	
	public void addUsuario(Usuario usuario)
	{
		try
		{
			session.setAttribute(ConstantesAtributos.USUARIO_SESSAO,usuario);
		}
		catch(IllegalStateException e)
		{
			throw new SessionException("A sessao ja foi desalocada",e);
		}
	}
	
	public Usuario getUsuario()
	{
		try
		{
			return (Usuario) session.getAttribute(ConstantesAtributos.USUARIO_SESSAO);
		}
		catch(IllegalStateException e)
		{
			throw new SessionException("A sessao ja foi desalocada",e);
		}
	}
	
	public void removeUsuario()
	{
		try
		{
			session.removeAttribute(ConstantesAtributos.USUARIO_SESSAO);
		}
		catch(IllegalStateException e)
		{
			throw new SessionException("A sessao ja foi desalocada",e);
		}
	}
	
	public Boolean hasUsuario()
	{
		return this.getUsuario() != null;
	}
	
	public void clearSession()
	{
		try
		{
			session.invalidate();
		}
		catch(IllegalStateException e)
		{
			throw new SessionException("A sessao ja foi desalocada",e);
		}
	}
}
