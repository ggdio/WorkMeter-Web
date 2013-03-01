package br.com.ggdio.workmeter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ggdio.workmeter.dao.DescricaoDao;
import br.com.ggdio.workmeter.model.Descricao;

@Service("descricaoService")
public final class DescricaoService extends DefaultService<Descricao>
{
	@Autowired
	public DescricaoService(DescricaoDao descricaoDao) 
	{
		super(descricaoDao);
	}
}
