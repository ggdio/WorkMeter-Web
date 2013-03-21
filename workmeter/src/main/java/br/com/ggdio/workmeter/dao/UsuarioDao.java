package br.com.ggdio.workmeter.dao;

import java.util.List;

import javax.persistence.Entity;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.ggdio.workmeter.model.Usuario;
import br.com.sourcesphere.core.util.StringUtils;
import br.com.sourcesphere.core.web.generic.dao.MasterDao;
import br.com.sourcesphere.core.web.generic.dao.exception.DaoException;
import br.com.sourcesphere.core.web.generic.dao.exception.EntityNotFoundException;

/**
 * Implementação do {@link DefaultDao}
 * @author Guilherme Dio
 *
 */
@Repository("usuarioDao")
public final class UsuarioDao extends MasterDao<Usuario>
{
	/**
	 * Construtor usado pelo Spring
	 * @param sessionFactory - Injetado pelo Spring
	 */
	@Autowired
	public UsuarioDao(SessionFactory sessionFactory) 
	{
		super(sessionFactory);
	}
	
	/**
	 * Realiza uma busca na base por usuario a partir de login e senha
	 * @param login do usuario
	 * @param senha do usuario
	 * @return Usuario encontrado
	 * @throws EntityNotFoundException - Se o usuario nao for encontrado na base
	 */
	public Usuario getUsuarioPorLoginESenha(String login,String senha)
	{
		try
		{
			String tabela = Usuario.class.getAnnotation(Entity.class).name();
			if(!StringUtils.hasText(tabela))
				tabela = "Usuario";
			return super.hqlQuery("from "+tabela+" where email = '"+login+"' and senha = '"+senha+"'",1).get(0);
		}
		catch(EntityNotFoundException e)
		{
			throw new EntityNotFoundException("Nenhum usuario foi encontrado com o login='"+login+"' e senha(criptografada)='"+senha+"'");
		}
		catch(DaoException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw new DaoException("Um erro inesperado ocorreu ao buscar o usuario na base de dados", e);
		}
	}
}
