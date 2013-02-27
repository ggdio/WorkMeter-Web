package br.com.ggdio.workmeter.controller;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ggdio.workmeter.dao.HoraDao;
import br.com.ggdio.workmeter.model.Hora;
import br.com.ggdio.workmeter.model.TipoHora;

@Controller
@RequestMapping("/hora/")
public final class HoraController extends MasterController 
{
	
	@RequestMapping("salvar")
	public void saveOrUpdate(HoraDao dao)
	{
		Hora hora = new Hora();
		hora.setId(null);
		hora.setRegistro(DateTime.now());
		hora.setTipo(TipoHora.INICIO);
		hora = dao.saveOrUpdate(hora);
		System.out.println(hora.getId());
	}
	
	@Override
	public String getBase() 
	{
		return "hora/";
	}
}
