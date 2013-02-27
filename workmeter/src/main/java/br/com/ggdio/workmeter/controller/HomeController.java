package br.com.ggdio.workmeter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController extends MasterController
{	
	@RequestMapping(value={"","index","home"})
	public String viewIndex()
	{
		return getView("index");
	}
	
	@RequestMapping("index/conteudo")
	public String viewConteudoIndex()
	{
		return getView("logado");
	}
	
	@Override
	public String getBase() 
	{
		return "home/";
	}
}
