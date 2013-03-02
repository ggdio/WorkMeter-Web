package br.com.ggdio.workmeter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ggdio.workmeter.dao.UsuarioDao;
import br.com.ggdio.workmeter.dao.exception.EntityNotFoundException;
import br.com.ggdio.workmeter.model.Usuario;
import br.com.ggdio.workmeter.service.exception.ServiceException;
import br.com.sourcesphere.core.seguranca.Criptografia;
import br.com.sourcesphere.core.seguranca.TipoAlgoritmo;

@Service("usuarioService")
public final class UsuarioService extends MasterService<Usuario>
{
	/**
	 * Dao de Usuario
	 */
	private UsuarioDao dao;
	
	private final TipoAlgoritmo algoritmo = TipoAlgoritmo.MD5;
	
	@Autowired
	public UsuarioService(UsuarioDao usuarioDao) 
	{
		super(usuarioDao);
		this.dao = (UsuarioDao) super.getDao();
	}
	
	@Override
	public void add(Usuario entity) 
	{
		//Criptografa a senha do usuario
		criptografarSenha(entity);
		super.add(entity);
	}
	
	/**
	 * Realiza uma busca na base por usuario a partir de login e senha
	 * @param login do usuario
	 * @param senha do usuario
	 * @return Usuario encontrado
	 * @throws EntityNotFoundException - Se o usuario nao existir
	 */
	public Usuario buscaPorLoginESenha(String login,String senha)
	{
		Usuario usuario;
		try
		{
			//Criptografa a senha
			senha = criptografarSenha(senha);
			usuario = dao.getUsuarioPorLoginESenha(login, senha);
		}
		catch(EntityNotFoundException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			String msg = "Ocorreu um erro inesperado ao buscar um usuario com o login("+login+") e senha("+senha+") no modelo";
			throw new ServiceException(msg,e);
		}
		return usuario;
	}
	
	/**
	 * Criptografa a senha do usuario utilizando o {@link #algoritmo}
	 * @param entity - Usuario a ser criptografado
	 */
	protected void criptografarSenha(Usuario entity)
	{
		entity.setSenha(criptografarSenha(entity.getSenha()));
	}
	
	/**
	 * Criptografa a String contendo a senha, utilizando o {@link #algoritmo}
	 * @param entity - Usuario a ser criptografado
	 */
	protected String criptografarSenha(String senha)
	{
		Criptografia.iniciar(algoritmo);
		String criptografia = Criptografia.gerarHash(senha);
		Criptografia.limpar();
		
		return criptografia;
	}
}
