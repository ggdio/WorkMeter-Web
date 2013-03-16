package br.com.ggdio.workmeter.interceptor;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.ggdio.workmeter.http.SessionUtil;
import br.com.sourcesphere.core.web.generic.controller.response.Response;

public class LoginInterceptor extends HandlerInterceptorAdapter
{
	Set<String> restritos = new HashSet<String>();
	{
		//Controller de Usuario
		restritos.add("/usuario/atualizar/");
		restritos.add("/usuario/remover/");
		restritos.add("/usuario/dados/");
		restritos.add("/usuario/login/sair/");
		
		//Controller de Preferencia
		restritos.add("/preferencias/atualizar/");
		restritos.add("/preferencias/formulario/");
		
		//Controller de Estilo
		restritos.add("/estilo/formulario/");
		restritos.add("/estilo/adicionar/");
		
		//Controller de Hora
		restritos.add("/hora/declarar/");
		restritos.add("/hora/descrever/");
		restritos.add("/hora/atualizar/");
		restritos.add("/hora/remover/");
	}
	
	private final String FORMULARIO_LOGIN = "/usuario/login/acesso";
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception 
	{
		SessionUtil sessionUtil = new SessionUtil(request);
		if(!sessionUtil.hasUsuario() && isUrlRestrito(request))
		{
			montaResponse(request);
			redireciona(request,response);
			return false;
		}
		return super.preHandle(request, response, handler);
	}
	
	private Boolean isUrlRestrito(HttpServletRequest request)
	{
		String contexto = request.getContextPath();
		String url = request.getRequestURI().substring(contexto.length());
		if(!url.endsWith("/"))
			url = url.concat("/");
		if(restritos.contains(url))
			return true;
		return false;
	}
	
	private void montaResponse(HttpServletRequest request)
	{
		Response<String> response = new Response<String>(Response.WARNING, "Você deve se logar no sistema para acessar a página");
		request.setAttribute("responseLogin", response);
	}
	
	private void redireciona(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher dispatcher =  request.getRequestDispatcher(FORMULARIO_LOGIN);
		dispatcher.forward(request, response);
	}
}
