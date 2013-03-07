package br.com.ggdio.workmeter.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.ggdio.workmeter.http.Attribute;
import br.com.ggdio.workmeter.http.ConstantesAtributos;
import br.com.ggdio.workmeter.http.RequestUtil;
import br.com.ggdio.workmeter.http.SessionUtil;
import br.com.ggdio.workmeter.model.Usuario;

public class GeralInterceptor extends HandlerInterceptorAdapter 
{
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
	{
		//Carrega o usuario da sessao(se existir)
		Usuario usuario = new SessionUtil(request).getUsuario();
		Attribute usuarioLogado = new Attribute(ConstantesAtributos.USUARIO_REQUEST, usuario);
		
		//Adiciona nos atributos do request
		new RequestUtil(request).addAttribute(usuarioLogado);
		
		//Continua
		super.postHandle(request, response, handler, modelAndView);
	}
}
