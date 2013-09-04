package br.com.ggdio.workmeter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ggdio.workmeter.exception.AppException;
import br.com.ggdio.workmeter.http.SessionUtil;
import br.com.ggdio.workmeter.model.Hora;
import br.com.ggdio.workmeter.model.TipoHora;
import br.com.ggdio.workmeter.model.Usuario;
import br.com.ggdio.workmeter.service.HoraService;
import br.com.sourcesphere.core.web.generic.controller.MasterController;
import br.com.sourcesphere.core.web.generic.dao.exception.EntityNotFoundException;
import br.com.sourcesphere.core.web.generic.service.exception.ServiceException;

@Controller
@RequestMapping("/hora/")
public final class HoraController extends MasterController<Hora>
{
	@Autowired
	public HoraController(HoraService horaService) 
	{
		super(horaService);
	}
	
	@RequestMapping("")
	public String viewInicio()
	{
		return super.getView("gerenciador");
	}
	
	@RequestMapping("conteudo")
	public String viewConteudo(HttpSession sessao)
	{
		String view = new String();
		HoraService horaService = (HoraService)super.getService();
		try
		{
			Hora ultima = horaService.getUltimaDeclarada(new SessionUtil(sessao).getUsuario());
			if(ultima.getTipo() == TipoHora.FIM)
				view = "inicio";
			else if(ultima.getTipo() == TipoHora.PAUSA)
				view = "pausado";
			else
				view = "iniciado";
		}
		catch(EntityNotFoundException e)
		{
			//Primeiro acesso
			view = "tutorial";
		}
		catch(Exception e)
		{
			throw new AppException(e);
		}
		return super.getView(view);
	}
	
	@RequestMapping("iniciar")
	public String iniciarDia(HttpSession sessao)
	{
		HoraService horaService = (HoraService) super.getService();
		Usuario usuario = new SessionUtil(sessao).getUsuario();
		try
		{
			horaService.iniciarDia(usuario);
		}
		catch(ServiceException e)
		{
			throw new AppException(e);
		}
		catch(Exception e)
		{
			throw new AppException(e);
		}
		return "redirect:/hora/";
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
