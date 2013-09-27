package br.com.ggdio.workmeter.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ggdio.workmeter.model.Idioma;
import br.com.sourcesphere.core.util.StringUtils;

/**
 * Controller for handling idiom cases
 * @author Guilherme Dio
 */
@Controller
@RequestMapping("/idioma/")
public class IdiomaController {
	
	@RequestMapping(value="alterar",method=RequestMethod.GET)
	public String alterarIdioma(String paginaAtual,String valor,HttpServletRequest request){
		alterarIdioma(Idioma.getValorDe(valor),request.getSession());
		if(!StringUtils.hasText(paginaAtual))
			paginaAtual = "/";
		return "redirect:"+paginaAtual;
		
	}
	
	private void alterarIdioma(Idioma idioma,HttpSession session){
		Locale locale = new java.util.Locale(idioma.getBundle(),idioma.getPais());
		Config.set(session, Config.FMT_LOCALE, locale);
	}
	
}
