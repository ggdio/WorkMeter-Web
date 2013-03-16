package br.com.ggdio.workmeter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ggdio.workmeter.converter.EstiloConverter;
import br.com.ggdio.workmeter.converter.IdiomaConverter;
import br.com.ggdio.workmeter.http.SessionUtil;
import br.com.ggdio.workmeter.model.Idioma;
import br.com.ggdio.workmeter.model.Preferencia;
import br.com.ggdio.workmeter.service.EstiloService;
import br.com.ggdio.workmeter.service.PreferenciaService;
import br.com.sourcesphere.core.web.generic.controller.MasterController;
import br.com.sourcesphere.core.web.generic.controller.response.Response;

@Controller
@RequestMapping("/preferencias/")
public final class PreferenciaController extends MasterController<Preferencia>
{
	@Autowired
	private EstiloService estiloService;
	
	@Autowired
	public PreferenciaController(PreferenciaService preferenciaService)
	{
		super(preferenciaService);
	}
	
	/**
	 * Formulario de preferencias
	 */
	@RequestMapping("atualizar")
	public String atualizar(Long idPreferencia,Long idEstilo,String idioma,HttpSession sessao,Model model)
	{
		Preferencia preferencia = super.get(idPreferencia);
		preferencia.setEstilo(estiloService.get(idEstilo));
		preferencia.setIdioma(Idioma.getValorDe(idioma));
		super.alter(preferencia);
		new SessionUtil(sessao).sincronizarPreferencias(preferencia);
		Response<Object> response = new Response<Object>(Response.SUCCESS, "Preferencias atualizadas com sucesso !");
		model.addAttribute("responsePreferenciaController",response);
		return "forward:/usuario/dados";
	}
	
	/**
	 * Formulario de preferencias
	 */
	@RequestMapping("formulario")
	public String viewFormulario(Model model)
	{
		model.addAttribute("estiloConverter", new EstiloConverter());
		model.addAttribute("idiomaConverter", new IdiomaConverter());
		model.addAttribute("estilos", estiloService.listAll());
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
