package br.com.ggdio.workmeter.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.ggdio.workmeter.dao.exception.DaoException;
import br.com.ggdio.workmeter.dao.exception.EntityNotFoundException;
import br.com.ggdio.workmeter.model.Usuario;

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
		Exception error = null;
		Usuario usuario = null;
		try
		{
			begin();
			Criteria criteria = getSession().createCriteria(Usuario.class)
											.setMaxResults(1)
											.add(Restrictions.eq("login", login))
											.add(Restrictions.eq("senha", senha));
			usuario = (Usuario) criteria.list().get(1);
		}
		catch(IndexOutOfBoundsException e)
		{
			String msg = "Nenhum usuario foi encontrado com o login='"+login+"' e senha='"+senha+"'";
			error = new EntityNotFoundException(msg, e);
		}
		catch(Exception e)
		{
			error = new Exception("Um erro inesperado ocorreu", e);
		}
		finally
		{
			close();
		}
		if(error != null) throw new DaoException(error);
		return usuario;
	}
}
