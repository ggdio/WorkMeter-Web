package br.com.ggdio.workmeter.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ggdio.workmeter.http.SessionUtil;


/**
 * Controlador da pagina inicial
 * @author Guilherme Dio
 *
 */
@Controller
@RequestMapping("/")
public class HomeController extends br.com.sourcesphere.core.web.generic.controller.Controller
{
	private final Logger log = Logger.getLogger(HomeController.class);
	
	/**
	 * Recupera a view index
	 * @return index
	 */
	@RequestMapping(value={"","index","home"})
	public String viewIndex()
	{
		return getView("index");
	}
	
	/**
	 * Recupera o conteudo do index
	 * @return Conteudo index
	 */
	@RequestMapping("index/conteudo")
	public String viewConteudoIndex(HttpSession sessao,Model model)
	{
		//Verifica se possui sessao
		if(new SessionUtil(sessao).hasUsuario())
		{
			//View com conteudo restrito
			return getView("logado");
		}
		else
		{
			//View com conteudo aberto
			return getView("deslogado");
		}
	}
	
	@Override
	public String getBase()
	{
		return "home/";
	}
	
	@Override
	public String getView(String view)
	{
		return getBase()+view;
	}
	
	@Override
	public String getPathBase() 
	{
		return "/";
	}

	@Override
	public String getGenericAttributeIdentifier() 
	{
		return "homeControllerResponse";
	}
}
