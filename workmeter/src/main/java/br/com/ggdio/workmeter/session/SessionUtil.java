<<<<<<< HEAD
package br.com.ggdio.workmeter.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.ggdio.workmeter.model.Usuario;
import br.com.ggdio.workmeter.session.exception.SessionException;

public class SessionUtil 
{
	private final HttpSession sessao;
	
	public static final String KEY_USUARIO = "usuario";
	
	public SessionUtil(HttpSession sessao)
	{
		this.sessao = sessao;
	}
	
	public SessionUtil(HttpServletRequest request) 
	{
		this(request.getSession());
	}
	
	public Usuario getUsuario()
	{
		try
		{
			return (Usuario) sessao.getAttribute(KEY_USUARIO);
		}
		catch(IllegalStateException e)
		{
			throw new SessionException("A sessao ja foi desalocada",e);
		}
	}
	
	public void addUsuario(Usuario usuario)
	{
		try
		{
			sessao.setAttribute(KEY_USUARIO,usuario);
		}
		catch(IllegalStateException e)
		{
			throw new SessionException("A sessao ja foi desalocada",e);
		}
	}
	
	public Boolean hasUsuario()
	{
		return sessao.getAttribute(KEY_USUARIO) != null;
	}
	
	public void removeUsuario()
	{
		try
		{
			sessao.removeAttribute(KEY_USUARIO);
		}
		catch(IllegalStateException e)
		{
			throw new SessionException("A sessao ja foi desalocada",e);
		}
	}
	
	public void clearSession()
	{
		try
		{
			sessao.invalidate();
		}
		catch(IllegalStateException e)
		{
			throw new SessionException("A sessao ja foi desalocada",e);
		}
	}
}
=======
package br.com.ggdio.workmeter.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.ggdio.workmeter.model.Usuario;
import br.com.ggdio.workmeter.session.exception.SessionException;

public class SessionUtil 
{
	private final HttpSession sessao;
	
	public static final String KEY_USUARIO = "usuario";
	
	public SessionUtil(HttpSession sessao)
	{
		this.sessao = sessao;
	}
	
	public SessionUtil(HttpServletRequest request) 
	{
		this(request.getSession());
	}
	
	public Usuario getUsuario()
	{
		try
		{
			return (Usuario) sessao.getAttribute(KEY_USUARIO);
		}
		catch(IllegalStateException e)
		{
			throw new SessionException("A sessao ja foi desalocada",e);
		}
	}
	
	public void setUsuario(Usuario usuario)
	{
		try
		{
			sessao.setAttribute(KEY_USUARIO,usuario);
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
			sessao.removeAttribute(KEY_USUARIO);
		}
		catch(IllegalStateException e)
		{
			throw new SessionException("A sessao ja foi desalocada",e);
		}
	}
	
	public void clearSession()
	{
		try
		{
			sessao.invalidate();
		}
		catch(IllegalStateException e)
		{
			throw new SessionException("A sessao ja foi desalocada",e);
		}
	}
}
>>>>>>> 8ef73d3a5d1f09a7795a111918af323948442114
