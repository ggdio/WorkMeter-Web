package br.com.ggdio.workmeter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ggdio.workmeter.model.Hora;
import br.com.ggdio.workmeter.service.HoraService;
import br.com.sourcesphere.core.web.controller.MasterController;

@Controller
@RequestMapping("/hora/")
public final class HoraController extends MasterController<Hora>
{
	@Autowired
	public HoraController(HoraService horaService) 
	{
		super(horaService);
	}
	
	@Override
	public String getBase() 
	{
		return "hora/";
	}
	
	@Override
	public String getPathBase() 
	{
		return "/hora/";
	}
}
