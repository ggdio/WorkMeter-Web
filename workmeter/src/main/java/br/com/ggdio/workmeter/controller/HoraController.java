package br.com.ggdio.workmeter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ggdio.workmeter.model.Hora;
import br.com.ggdio.workmeter.service.HoraService;

@Controller
@RequestMapping("/hora/")
public final class HoraController extends MasterController 
{
	@Autowired
	private HoraService horaService;
	
	@RequestMapping("salvar")
	public void saveOrUpdate(Hora hora)
	{
		horaService.adiciona(hora);
	}
	
	@Override
	public String getBase() 
	{
		return "hora/";
	}
}
