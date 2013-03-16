package br.com.ggdio.workmeter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ggdio.workmeter.model.Estilo;
import br.com.ggdio.workmeter.service.EstiloService;
import br.com.sourcesphere.core.web.generic.controller.MasterController;

@Controller
@RequestMapping("/estilo/")
public class EstiloController extends MasterController<Estilo> 
{
	@Autowired
	public EstiloController(EstiloService estiloService) 
	{
		super(estiloService);
	}
	
	@RequestMapping("formulario")
	public String viewFormulario()
	{
		return getView("");
	}
	
	@Override
	public String getBase() 
	{
		return "estilo/";
	}
	
	@Override
	public String getPathBase() 
	{
		return "/estilo/";
	}
}
