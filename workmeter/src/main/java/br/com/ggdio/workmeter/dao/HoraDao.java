package br.com.ggdio.workmeter.dao;

import javax.persistence.Entity;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.ggdio.workmeter.model.Hora;
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
@Repository("horaDao")
public final class HoraDao extends MasterDao<Hora>
{
	/**
	 * Construtor usado pelo Spring
	 * @param sessionFactory - Injetado pelo Spring
	 */
	@Autowired
	public HoraDao(SessionFactory sessionFactory) 
	{
		super(sessionFactory);
	}

	public Hora getUltimaDeclarada(Usuario usuario) 
	{
		try
		{
			String tblHora = Hora.class.getAnnotation(Entity.class).name();
			String cmpUsuario = "usuario_id";
			if(!StringUtils.hasText(tblHora))
				tblHora = "Hora";
			return super.hqlQuery("from "+tblHora+" where "+cmpUsuario+" = "+usuario.getId()+" order by registro desc", 1).get(0);
		}
		catch(EntityNotFoundException e)
		{
			throw new EntityNotFoundException("Nenhuma hora foi encontrada");
		}
		catch(DaoException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw new DaoException("Ocorreu um erro inesperado ao buscar o ultimo registro de hora");
		}
	}
}
