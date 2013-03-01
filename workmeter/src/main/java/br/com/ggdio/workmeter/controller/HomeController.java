package br.com.ggdio.workmeter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Controlador da pagina inicial
 * @author guilherme
 *
 */
@Controller
@RequestMapping("/")
public class HomeController extends DefaultController<Object>
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
		return super.getBase()+"home/";
	}
}
