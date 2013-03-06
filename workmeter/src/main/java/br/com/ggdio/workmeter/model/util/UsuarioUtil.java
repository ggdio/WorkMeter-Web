package br.com.ggdio.workmeter.model.util;

import br.com.ggdio.workmeter.model.Usuario;
import br.com.ggdio.workmeter.service.UsuarioService;
import br.com.sourcesphere.core.util.Assert;
import br.com.sourcesphere.core.web.dao.exception.EntityNotFoundException;

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
	 * Verifica se o login e senha do usuario sao validos
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
