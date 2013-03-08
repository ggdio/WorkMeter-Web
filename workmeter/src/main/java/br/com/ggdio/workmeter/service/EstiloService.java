package br.com.ggdio.workmeter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ggdio.workmeter.dao.EstiloDao;
import br.com.ggdio.workmeter.model.Estilo;
import br.com.sourcesphere.core.web.generic.service.MasterService;

@Service("estiloService")
public class EstiloService extends MasterService<Estilo>
{
	@Autowired
	public EstiloService(EstiloDao estiloDao) 
	{
		super(estiloDao);
	}
}
