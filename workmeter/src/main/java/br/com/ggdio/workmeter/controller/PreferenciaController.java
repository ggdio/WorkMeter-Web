package br.com.ggdio.workmeter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ggdio.workmeter.converter.EstiloConverter;
import br.com.ggdio.workmeter.converter.IdiomaConverter;
import br.com.ggdio.workmeter.model.Preferencia;
import br.com.ggdio.workmeter.service.PreferenciaService;
import br.com.sourcesphere.core.web.generic.controller.MasterController;

@Controller
@RequestMapping("/preferencias/")
public final class PreferenciaController extends MasterController<Preferencia>
{
	@Autowired
	public PreferenciaController(PreferenciaService preferenciaService)
	{
		super(preferenciaService);
	}
	
	/**
	 * Formulario de preferencias
	 */
	@RequestMapping("atualizar")
	public String atualizar(Preferencia preferencia)
	{
		super.alter(preferencia);
		
		return "redirect:/usuario/dados";
	}
	
	/**
	 * Formulario de preferencias
	 */
	@RequestMapping("formulario")
	public String viewFormulario(Model model)
	{
		model.addAttribute("estiloConverter", new EstiloConverter());
		model.addAttribute("idiomaConverter", new IdiomaConverter());
		return getView("formulario");
	}
	
	@Override
	public String getBase() 
	{
		return "preferencia/";
	}
	
	@Override
	public String getPathBase() 
	{
		return "/preferencia/";
	}
}
