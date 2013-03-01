package br.com.ggdio.workmeter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ggdio.workmeter.dao.HoraDao;
import br.com.ggdio.workmeter.model.Hora;

@Service("horaService")
public final class HoraService extends DefaultService<Hora>
{
	@Autowired
	public HoraService(HoraDao horaDao) 
	{
		super(horaDao);
	}
}
