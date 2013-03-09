package br.com.ggdio.workmeter.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.ggdio.workmeter.model.Preferencia;
import br.com.sourcesphere.core.web.generic.dao.MasterDao;

@Repository("preferenciaDao")
public final class PreferenciaDao extends MasterDao<Preferencia> 
{
	@Autowired
	public PreferenciaDao(SessionFactory sessionFactory) 
	{
		super(sessionFactory);
	}
}
