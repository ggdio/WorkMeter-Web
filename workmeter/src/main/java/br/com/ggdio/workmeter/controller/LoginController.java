package br.com.ggdio.workmeter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ggdio.workmeter.view.ViewHandler;

@Controller
@RequestMapping("/login/")
public class LoginController implements ViewHandler 
{
	@RequestMapping("formulario")
	public String viewFormulario()
	{
		return getView("formulario");
	}
	
	@RequestMapping("executa")
	public String executa()
	{
		//Validar e gravar sessão
		return viewFormulario();
	}

	@Override
	public String getBase() 
	{
		return "login/";
	}

	@Override
	public String getView(String view) 
	{
		return getBase()+view;
	}

}
