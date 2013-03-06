package br.com.ggdio.workmeter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ggdio.workmeter.session.SessionUtil;
import br.com.sourcesphere.core.web.view.PathHandler;
import br.com.sourcesphere.core.web.view.ViewHandler;


/**
 * Controlador da pagina inicial
 * @author Guilherme Dio
 *
 */
@Controller
@RequestMapping("/")
public class HomeController implements ViewHandler,PathHandler
{
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
	public String viewConteudoIndex(HttpSession sessao)
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
}
