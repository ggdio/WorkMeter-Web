package br.com.ggdio.workmeter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ggdio.workmeter.dao.DescricaoDao;
import br.com.ggdio.workmeter.model.Descricao;
import br.com.sourcesphere.core.web.service.MasterService;

@Service("descricaoService")
public final class DescricaoService extends MasterService<Descricao>
{
	@Autowired
	public DescricaoService(DescricaoDao descricaoDao) 
	{
		super(descricaoDao);
	}
}
