package br.com.ggdio.workmeter.dao;

import org.apache.log4j.Logger;
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
public final class UsuarioDao extends DefaultDao<Usuario>
{
	private Logger log = Logger.getLogger(UsuarioDao.class);
	/**
	 * Construtor usado pelo Spring
	 * @param sessionFactory - Injetado pelo Spring
	 */
	@Autowired
	public UsuarioDao(SessionFactory sessionFactory) 
	{
		super(sessionFactory);
	}
	
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
		catch(NullPointerException e)
		{
			String msg = "Nenhum usuario foi encontrado com o login='"+login+"' e senha='"+senha+"'";
			error = new EntityNotFoundException(msg, e);
			log.warn(msg);
		}
		catch(Exception e)
		{
			error = e;
			log.error("Erro ao buscar usuario por login e senha('"+login+"','"+senha+"') ",e);
		}
		finally
		{
			close();
		}
		if(error != null) throw new DaoException(error);
		return usuario;
	}
}
