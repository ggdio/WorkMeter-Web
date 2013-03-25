package br.com.ggdio.workmeter.controller;

import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
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
		return getView("gerenciador");
	}
	
	@RequestMapping("conteudo")
	public String viewConteudo(HttpSession sessao)
	{
		String view = "[null]";
		HoraService horaService = (HoraService)super.getService();
		try
		{
			Hora ultima = horaService.getUltimaDeclarada(new SessionUtil(sessao).getUsuario());
			switch(ultima.getTipo())
			{
				case FIM:
					view = "inicio";
				case PAUSA:
					view = "pausado";
				default:
					view = "iniciado";
			}
		}
		catch(EntityNotFoundException e)
		{
			view = "tutorial";
		}
		catch(Exception e)
		{
			throw new AppException(e);
		}
		return getView(view);
	}
	
	@RequestMapping("iniciar")
	public String iniciarDia(HttpSession sessao)
	{
		HoraService horaService = (HoraService) super.getService();
		Usuario usuario = new SessionUtil(sessao).getUsuario();
		try
		{
			horaService.declararHora(new Hora(hoje(), TipoHora.INICIO, usuario));
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
	
	public DateTime hoje()
	{
		return DateTime.now();
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
