package br.com.ggdio.workmeter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ggdio.workmeter.dao.UsuarioDao;
import br.com.ggdio.workmeter.model.Usuario;

@Service("usuarioService")
public final class UsuarioService extends DefaultService<Usuario>
{
	@Autowired
	public UsuarioService(UsuarioDao usuarioDao) 
	{
		super(usuarioDao);
	}
}
