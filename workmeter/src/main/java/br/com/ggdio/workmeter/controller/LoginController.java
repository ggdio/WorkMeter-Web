<<<<<<< HEAD
package br.com.ggdio.workmeter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.ggdio.workmeter.controller.response.Response;
import br.com.ggdio.workmeter.controller.response.ResponseDispatcher;
import br.com.ggdio.workmeter.controller.response.ResponseStatus;
import br.com.ggdio.workmeter.model.util.UsuarioUtil;
import br.com.ggdio.workmeter.service.UsuarioService;
import br.com.ggdio.workmeter.session.SessionUtil;

@Controller
@RequestMapping("/login/")
public class LoginController extends br.com.ggdio.workmeter.controller.Controller
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
	public String executa(String login,String senha,HttpServletRequest request,Model model)
	{
		SessionUtil sessionUtil = new SessionUtil(request);

		//Valida se o usuario ja esta na sessao
		if(sessionUtil.getUsuario() != null)
		{
			//Redirect para o formulario de login com mensagem de alerta
			prepareRedirect(request, new Response<String>(ResponseStatus.ERROR, "Voce ja esta conectado !"), dispatcher, "loginControllerResponse", "formulario");
			return dispatcher.toString();
		}
		
		//Valida login/senha
		UsuarioUtil util = new UsuarioUtil(login, senha, usuarioService);
		if(!util.isUsuarioValido())
		{
			//Forward para o formulario de login com mensagem de alerta
			prepareForward(request, new Response<String>(ResponseStatus.ERROR, "Login e/ou Senha invalidos !"), dispatcher, "loginControllerResponse", "formulario");
			return dispatcher.toString();
		}
		
		//Adiciona o usuario na sessao
		sessionUtil.addUsuario(util.getUsuario());
		UriComponents redirectUri = UriComponentsBuilder.fromPath("/login").build().encode();  
		//Redirect para o formulario de login com mensagem de alerta
		//model.addAttribute("serverResponse",new Response<String>(ResponseStatus.SUCCESS,"Seja bem vindo "+util.getUsuario().getNome()+" !"));
		return "redirect:"+redirectUri;
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
	
	@Override
	public void prepareForward(HttpServletRequest request,Response<?> response,ResponseDispatcher dispatcher,String identifier,String destine)
	{
		dispatcher.changePathHandler(new HomeController());
		dispatcher.loadResponse(ResponseDispatcher.FORWARD ,request, response, identifier, destine);
	}
	
	@Override
	public void prepareRedirect(HttpServletRequest request,Response<?> response,ResponseDispatcher dispatcher,String identifier,String destine)
	{
		dispatcher.changePathHandler(new HomeController());
		dispatcher.loadResponse(ResponseDispatcher.REDIRECT, request, response, identifier, destine);
	}

}
=======
package br.com.ggdio.workmeter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ggdio.workmeter.controller.response.Response;
import br.com.ggdio.workmeter.controller.response.ResponseDispatcher;
import br.com.ggdio.workmeter.controller.response.ResponseStatus;
import br.com.ggdio.workmeter.model.util.UsuarioUtil;
import br.com.ggdio.workmeter.service.UsuarioService;
import br.com.ggdio.workmeter.session.SessionUtil;

@Controller
@RequestMapping("/login/")
public class LoginController extends br.com.ggdio.workmeter.controller.Controller
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
	public String executa(String login,String senha,HttpServletRequest request)
	{
		SessionUtil sessionUtil = new SessionUtil(request);
		//Valida se o usuario ja esta na sessao
		if(sessionUtil.getUsuario() != null)
		{
			//Forward para o formulario de login com mensagem de alerta
			prepareForward(request, new Response<String>(ResponseStatus.ERROR, "Voce ja esta conectado !"), dispatcher, "loginControllerResponse");
			return dispatcher.generateForwardDispatch("formulario");
		}
		
		//Verifica se o usuario é valido
		UsuarioUtil util = new UsuarioUtil(login, senha, usuarioService);
		if(!util.isUsuarioValido())
		{
			//Forward para o formulario de login com mensagem de alerta
			prepareForward(request, new Response<String>(ResponseStatus.ERROR, "Login e/ou Senha invalidos !"), dispatcher, "loginControllerResponse");
			return dispatcher.generateForwardDispatch("formulario");
		}
		
		//Forward para o formulario de login com mensagem de alerta
		prepareForward(request, new Response<String>(ResponseStatus.ERROR, "Seja bem vindo !"), dispatcher, "loginControllerResponse");
		return dispatcher.generateForwardDispatch("formulario");
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
	
	@Override
	public void prepareForward(HttpServletRequest request,Response<?> response,ResponseDispatcher dispatcher,String identifier)
	{
		dispatcher.loadResponse(request, response, identifier);
	}
	
	@Override
	public void prepareRedirect(HttpServletRequest request,Response<?> response,ResponseDispatcher dispatcher,String identifier)
	{
		dispatcher.loadResponse(request, response, identifier);
	}

}
>>>>>>> 8ef73d3a5d1f09a7795a111918af323948442114
