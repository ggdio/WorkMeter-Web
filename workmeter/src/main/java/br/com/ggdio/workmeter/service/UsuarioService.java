package br.com.ggdio.workmeter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ggdio.workmeter.dao.UsuarioDao;
import br.com.ggdio.workmeter.dao.exception.EntityNotFoundException;
import br.com.ggdio.workmeter.model.Usuario;

@Service("usuarioService")
public final class UsuarioService extends MasterService<Usuario>
{
	@Autowired
	public UsuarioService(UsuarioDao usuarioDao) 
	{
		super(usuarioDao);
	}
	
	public Usuario buscaPorLoginESenha(String login,String senha)
	{
		Usuario usuario = null;
		try
		{
			UsuarioDao dao = (UsuarioDao) super.getDao();
			usuario = dao.getUsuarioPorLoginESenha(login, senha);
		}
		catch(EntityNotFoundException e)
		{
			//Throw com ServiceException
		}
		catch(Exception e)
		{
			//Tratar e dar throw com service exception
		}
		return usuario;
	}
}
