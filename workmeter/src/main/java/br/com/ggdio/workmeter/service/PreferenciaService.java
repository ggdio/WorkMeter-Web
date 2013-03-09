package br.com.ggdio.workmeter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ggdio.workmeter.dao.PreferenciaDao;
import br.com.ggdio.workmeter.model.Preferencia;
import br.com.sourcesphere.core.web.generic.service.MasterService;

@Service("preferenciaService")
public final class PreferenciaService extends MasterService<Preferencia> 
{
	@Autowired
	public PreferenciaService(PreferenciaDao preferenciaDao) 
	{
		super(preferenciaDao);
	}
}
