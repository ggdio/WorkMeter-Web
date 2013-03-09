package br.com.ggdio.workmeter.controller;

import java.util.Arrays;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ggdio.workmeter.http.SessionUtil;
import br.com.ggdio.workmeter.model.Idioma;
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
	public String viewFormulario(HttpSession sessao,Model model)
	{
		Preferencia preferencia = new SessionUtil(sessao).getUsuario().getPreferencia();
		//model.addAttribute("estilos",listaEstilos);
		model.addAttribute("idiomas", Arrays.asList(Idioma.values()));
		model.addAttribute("preferencia",preferencia);
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
