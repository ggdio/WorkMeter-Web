package br.com.ggdio.workmeter.model.util;

import br.com.ggdio.workmeter.model.Usuario;
import br.com.ggdio.workmeter.service.UsuarioService;

public final class UsuarioUtil 
{
	private final Usuario usuario;
	private final UsuarioService service;
	
	public UsuarioUtil(Usuario usuario, UsuarioService service) 
	{
		this.usuario = usuario;
		this.service = service;
	}
	
	public Boolean isUsuarioValido()
	{
		Usuario busca = service.buscaPorLoginESenha(usuario.getLogin(), usuario.getSenha());
		if(busca == null)
			return false;
		return true;
	}
}
