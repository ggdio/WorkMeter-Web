package br.com.ggdio.workmeter.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ggdio.workmeter.dao.UsuarioDao;
import br.com.ggdio.workmeter.model.Idioma;
import br.com.ggdio.workmeter.model.Preferencia;
import br.com.ggdio.workmeter.model.Usuario;
import br.com.sourcesphere.core.seguranca.Criptografia;
import br.com.sourcesphere.core.seguranca.TipoAlgoritmo;
import br.com.sourcesphere.core.web.generic.dao.exception.DaoException;
import br.com.sourcesphere.core.web.generic.dao.exception.EntityNotFoundException;
import br.com.sourcesphere.core.web.generic.service.MasterService;
import br.com.sourcesphere.core.web.generic.service.exception.ServiceException;

@Service("usuarioService")
public final class UsuarioService extends MasterService<Usuario>
{	
	@Autowired
	private EstiloService estiloService;
	
	/**
	 * Tipo de algoritmo padrão para hash
	 */
	private final TipoAlgoritmo algoritmo = TipoAlgoritmo.MD5;
	
	/**
	 * Logger
	 */
	private static final Logger log = Logger.getLogger(UsuarioService.class);
	
	@Autowired
	public UsuarioService(UsuarioDao usuarioDao) 
	{
		super(usuarioDao);
	}
	
	@Override
	public void add(Usuario entity) 
	{
		//Criptografa a senha do usuario
		criptografarSenha(entity);
		
		//Adiciona as preferencias default
		Preferencia preferencia = new Preferencia();
		preferencia.setEstilo(estiloService.getEstiloDefault());
		preferencia.setIdioma(Idioma.PORTUGUES_BR);
		entity.setPreferencia(preferencia);
		entity.setAtivo(true);
		
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
		UsuarioDao dao = (UsuarioDao) super.getDao();
		try
		{
			//Criptografa a senha e faz a busca
			return dao.getUsuarioPorLoginESenha(login, criptografarSenha(senha));
		}
		catch(EntityNotFoundException e)
		{
			log.warn(e.getMessage(), e);
			throw e;
		}
		catch(DaoException e)
		{
			log.error(e.getMessage(), e);
			throw e;
		}
		catch(Exception e)
		{
			log.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}
	
	/**
	 * Criptografa a senha do usuario utilizando o {@link #algoritmo}
	 * @param entity - Usuario a ser criptografado
	 */
	private void criptografarSenha(Usuario entity)
	{
		entity.setSenha(criptografarSenha(entity.getSenha()));
	}
	
	/**
	 * Criptografa a String contendo a senha, utilizando o {@link #algoritmo}
	 * @param entity - Usuario a ser criptografado
	 */
	private String criptografarSenha(String senha)
	{
		Criptografia.iniciar(algoritmo);
		String criptografia = Criptografia.gerarHash(senha);
		Criptografia.limpar();
		
		return criptografia;
	}
}
