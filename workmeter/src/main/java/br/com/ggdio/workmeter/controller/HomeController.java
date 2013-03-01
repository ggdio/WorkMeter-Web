package br.com.ggdio.workmeter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SuppressWarnings(value={"unchecked","rawtypes"})
@Controller
@RequestMapping("/")

/**
 * Controlador da pagina inicial
 * @author guilherme
 *
 */
public class HomeController extends DefaultController
{
	public HomeController() 
	{
		super(null);
	}
	
	@RequestMapping(value={"","index","home"})
	public String viewIndex()
	{
		return getView("index");
	}
	
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
}
