package br.com.ggdio.workmeter.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.ggdio.workmeter.model.Estilo;
import br.com.sourcesphere.core.web.generic.dao.MasterDao;

@Repository("estiloDao")
public class EstiloDao extends MasterDao<Estilo> 
{
	@Autowired
	public EstiloDao(SessionFactory sessionFactory) 
	{
		super(sessionFactory);
	}
}
