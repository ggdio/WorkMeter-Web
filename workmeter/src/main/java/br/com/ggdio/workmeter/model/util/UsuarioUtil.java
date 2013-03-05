<<<<<<< HEAD
package br.com.ggdio.workmeter.model.util;

import br.com.ggdio.workmeter.dao.exception.DaoException;
import br.com.ggdio.workmeter.dao.exception.EntityNotFoundException;
import br.com.ggdio.workmeter.model.Usuario;
import br.com.ggdio.workmeter.service.UsuarioService;
import br.com.ggdio.workmeter.service.exception.ServiceException;
import br.com.sourcesphere.core.util.Assert;

/**
 * Classe com utilidades para handle de usuario
 * @author Guilherme Dio
 *
 */
public final class UsuarioUtil 
{
	private Usuario usuario;
	private final UsuarioService service;
	
	/**
	 * Assert para segurança
	 */
	private final Assert assertion = new Assert();
	
	/**
	 * Constroi um {@link UsuarioUtil} com um {@link Usuario} e um {@link UsuarioService}
	 * @param usuario - Objeto contendo o usuario
	 * @param service - Serviço para negocios
	 */
	public UsuarioUtil(Usuario usuario, UsuarioService service) 
	{
		assertion.notNull(usuario);
		assertion.notNull(service);
		this.usuario = usuario;
		this.service = service;
	}
	
	/**
	 * Constroi um {@link UsuarioUtil} com um login e senha, e um {@link UsuarioService}
	 * @param usuario - Objeto contendo o usuario
	 * @param service - Serviço para negocios
	 */
	public UsuarioUtil(String login,String senha, UsuarioService service) 
	{
		this(new Usuario(login, senha),service);
	}
	
	/**
	 * Verifica se o login e senha do usuario é valido
	 * @return True - Se for valido
	 * 		<p>False - Se não for valido
	 */
	public Boolean isUsuarioValido()
	{
		try
		{
			this.usuario = service.buscaPorLoginESenha(usuario.getLogin(), usuario.getSenha());
			return true;
		}
		catch(EntityNotFoundException e)
		{
			return false;
		}
		catch(DaoException e)
		{
			throw e;
		}
		catch(ServiceException e)
		{
			throw e;
		}
	}
	
	public Usuario getUsuario()
	{
		return this.usuario;
	}
}
=======
package br.com.ggdio.workmeter.model.util;

import br.com.ggdio.workmeter.dao.exception.EntityNotFoundException;
import br.com.ggdio.workmeter.model.Usuario;
import br.com.ggdio.workmeter.service.UsuarioService;
import br.com.sourcesphere.core.util.Assert;

/**
 * Classe com utilidades para handle de usuario
 * @author Guilherme Dio
 *
 */
public final class UsuarioUtil 
{
	private Usuario usuario;
	private final UsuarioService service;
	
	/**
	 * Assert para segurança
	 */
	private final Assert assertion = new Assert();
	
	/**
	 * Constroi um {@link UsuarioUtil} com um {@link Usuario} e um {@link UsuarioService}
	 * @param usuario - Objeto contendo o usuario
	 * @param service - Serviço para negocios
	 */
	public UsuarioUtil(Usuario usuario, UsuarioService service) 
	{
		assertion.notNull(usuario);
		assertion.notNull(service);
		this.usuario = usuario;
		this.service = service;
	}
	
	/**
	 * Constroi um {@link UsuarioUtil} com um login e senha, e um {@link UsuarioService}
	 * @param usuario - Objeto contendo o usuario
	 * @param service - Serviço para negocios
	 */
	public UsuarioUtil(String login,String senha, UsuarioService service) 
	{
		this(new Usuario(login, senha),service);
	}
	
	/**
	 * Verifica se o login e senha do usuario é valido
	 * @return True - Se for valido
	 * 		<p>False - Se não for valido
	 */
	public Boolean isUsuarioValido()
	{
		try
		{
			this.usuario = service.buscaPorLoginESenha(usuario.getLogin(), usuario.getSenha());
		}
		catch(EntityNotFoundException e)
		{
			return false;
		}
		return true;
	}
	
	public Usuario getUsuario()
	{
		return this.usuario;
	}
}
>>>>>>> 8ef73d3a5d1f09a7795a111918af323948442114
