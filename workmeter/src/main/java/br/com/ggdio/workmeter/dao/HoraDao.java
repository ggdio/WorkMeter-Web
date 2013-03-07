package br.com.ggdio.workmeter.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.ggdio.workmeter.model.Hora;
import br.com.sourcesphere.core.web.generic.dao.MasterDao;

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
}
