package br.com.ggdio.workmeter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ggdio.workmeter.view.ViewHandler;


/**
 * Controlador da pagina inicial
 * @author Guilherme Dio
 *
 */
@Controller
@RequestMapping("/")
public class HomeController implements ViewHandler
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
	public String viewConteudoIndex()
	{
		return getView("deslogado");
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
}
