package br.com.ggdio.workmeter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ggdio.workmeter.controller.response.Response;
import br.com.ggdio.workmeter.controller.response.ResponseDispatcher;
import br.com.ggdio.workmeter.controller.response.ResponseStatus;
import br.com.ggdio.workmeter.model.util.UsuarioUtil;
import br.com.ggdio.workmeter.service.UsuarioService;
import br.com.ggdio.workmeter.view.PathHandler;
import br.com.ggdio.workmeter.view.ViewHandler;
import br.com.sourcesphere.core.util.Assert;

@Controller
@RequestMapping("/login/")
public class LoginController implements ViewHandler,PathHandler
{
	@Autowired
	private UsuarioService usuarioService;
	private final ResponseDispatcher dispatcher = new ResponseDispatcher(this);
	
	@RequestMapping("formulario")
	public String viewFormulario()
	{
		return getView("formulario");
	}
	
	@RequestMapping("executa")
	public String executa(String login,String senha,Model model)
	{
		UsuarioUtil util = new UsuarioUtil(login, senha, usuarioService);
		try
		{
			new Assert(IllegalStateException.class).isTrue(util.isUsuarioValido());
		}
		catch(IllegalStateException e)
		{
			//Forward para o formulario de login
			Response<String> response = new Response<String>(ResponseStatus.ERROR, "Login e/ou Senha invalidos !");
			dispatcher.loadResponse(model, response, "responseLoginController");
			return dispatcher.forwardDispatch("formulario");
		}
		return new HomeController().viewIndex();
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
	
	@Override
	public String getPathBase() 
	{
		return "/login/";
	}

}
