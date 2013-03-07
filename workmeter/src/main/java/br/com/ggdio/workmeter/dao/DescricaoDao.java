package br.com.ggdio.workmeter.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.ggdio.workmeter.model.Descricao;
import br.com.sourcesphere.core.web.dao.MasterDao;

/**
 * Implementação do {@link DefaultDao}
 * @author Guilherme Dio
 *
 */
@Repository("descricaoDao")
public final class DescricaoDao extends MasterDao<Descricao>
{
	/**
	 * Construtor usado pelo Spring
	 * @param sessionFactory - Injetado pelo Spring
	 */
	@Autowired
	public DescricaoDao(SessionFactory sessionFactory) 
	{
		super(sessionFactory);
	}
}
