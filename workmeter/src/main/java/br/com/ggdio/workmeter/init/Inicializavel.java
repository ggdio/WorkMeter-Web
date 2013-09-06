package br.com.ggdio.workmeter.init;

import br.com.sourcesphere.core.web.generic.dao.MasterDao;

public interface Inicializavel {
	public void init(MasterDao<?>...daos);
}
