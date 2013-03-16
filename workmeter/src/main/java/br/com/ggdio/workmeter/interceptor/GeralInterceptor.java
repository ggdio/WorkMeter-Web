package br.com.ggdio.workmeter.interceptor;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.ggdio.workmeter.http.Attribute;
import br.com.ggdio.workmeter.http.ConstantesAtributos;
import br.com.ggdio.workmeter.http.RequestUtil;
import br.com.ggdio.workmeter.http.SessionUtil;
import br.com.ggdio.workmeter.model.Idioma;
import br.com.ggdio.workmeter.model.Usuario;

public class GeralInterceptor extends HandlerInterceptorAdapter 
{
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
	{
		RequestUtil reqUtil = new RequestUtil(request);
		Usuario usuario = new SessionUtil(request).getUsuario();
		
		//Carrega os atributos
		Attribute usuarioLogado = new Attribute(ConstantesAtributos.USUARIO_REQUEST, usuario);
		Attribute idiomas = new Attribute(ConstantesAtributos.IDIOMAS_REQUEST, Arrays.asList(Idioma.values()));
		
		
		//Adiciona o usuario no request, e os idiomas necessarios
		reqUtil.addAttribute(usuarioLogado);
		reqUtil.addAttribute(idiomas);
		
		//Continua
		super.postHandle(request, response, handler, modelAndView);
	}
}
