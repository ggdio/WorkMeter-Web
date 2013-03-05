package br.com.ggdio.workmeter.dao;

import java.util.List;

import javax.persistence.Entity;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.ggdio.workmeter.dao.exception.DaoException;
import br.com.ggdio.workmeter.dao.exception.EntityNotFoundException;
import br.com.ggdio.workmeter.model.Usuario;
import br.com.sourcesphere.core.util.StringUtils;

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
			begin();
			String tabela = Usuario.class.getAnnotation(Entity.class).name();
			if(!StringUtils.hasText(tabela))
				tabela = "Usuario";
			List<Usuario> resultado = super.hqlQuery("from "+tabela+" where login = '"+login+"' and senha = '"+senha+"'",1);
			commit();
			return resultado.get(0);
		}
		catch(EntityNotFoundException e)
		{
			rollback();
			throw new EntityNotFoundException("Nenhum usuario foi encontrado com o login='"+login+"' e senha(criptografada)='"+senha+"'");
			
		}
		catch(Exception e)
		{
			rollback();
			throw new DaoException("Um erro inesperado ocorreu ao buscar o usuario na base de dados", e);
		}
		finally
		{
			close();
		}
	}
}
