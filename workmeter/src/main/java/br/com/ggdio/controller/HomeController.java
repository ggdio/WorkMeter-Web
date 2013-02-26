package br.com.ggdio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController extends MasterController
{
	@RequestMapping("index")
	public String getIndex()
	{
		return getView("index");
	}
	
	@RequestMapping("index/conteudo")
	public String getConteudoIndex()
	{
		return getView("conteudo");
	}
	
	@Override
	public String getBase() 
	{
		return "home/";
	}
}
