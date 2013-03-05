<<<<<<< HEAD
package br.com.ggdio.workmeter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ggdio.workmeter.session.SessionUtil;
import br.com.ggdio.workmeter.view.PathHandler;
import br.com.ggdio.workmeter.view.ViewHandler;


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
	public String viewIndex(HttpServletRequest request)
	{
		return getView("index");
	}
	
	/**
	 * Recupera o conteudo do index
	 * @return Conteudo index
	 */
	@RequestMapping("index/conteudo")
	public String viewConteudoIndex(HttpSession session)
	{
		//Valida se usuario esta na sessap
		if(!new SessionUtil(session).hasUsuario())
			return getView("deslogado");
		
		//Retorna o conteudo do index
		return getView("logado");
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
=======
package br.com.ggdio.workmeter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ggdio.workmeter.view.PathHandler;
import br.com.ggdio.workmeter.view.ViewHandler;


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
	public String viewConteudoIndex(HttpSession session)
	{
		if(session.getAttribute("usuarioLogado") == null)
			return getView("deslogado");
		
		return getView("logado");
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
>>>>>>> 8ef73d3a5d1f09a7795a111918af323948442114
