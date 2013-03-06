package br.com.ggdio.workmeter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ggdio.workmeter.model.Usuario;
import br.com.ggdio.workmeter.model.util.UsuarioUtil;
import br.com.ggdio.workmeter.service.UsuarioService;
import br.com.ggdio.workmeter.session.SessionUtil;
import br.com.sourcesphere.core.web.controller.MasterController;
import br.com.sourcesphere.core.web.controller.response.Response;

@Controller
@RequestMapping("/usuario/")
public final class UsuarioController extends MasterController<Usuario>
{
	@Autowired
	public UsuarioController(UsuarioService usuarioService) 
	{
		super(usuarioService);
	}
	
	/**
	 * Adiciona um usuario
	 */
	@Override
	@RequestMapping(value="criar",method=RequestMethod.POST)
	public void add(Usuario usuario)
	{
		super.add(usuario);
	}
	
	/**
	 * Altera um usuario
	 */
	@Override
	@RequestMapping(value="alterar",method=RequestMethod.POST)
	public void alter(Usuario usuario)
	{
		super.alter(usuario);
	}
	
	/**
	 * Remove um usuario
	 */
	@Override
	@RequestMapping(value="remover",method=RequestMethod.POST)
	public void delete(Usuario usuario)
	{
		super.delete(usuario);
	}
	
	/**
	 * Formulario de cadastro de usuario
	 */
	@RequestMapping("formulario")
	public String viewFormularioCadastro()
	{
		return getView("formulario");
	}
	
	/**
	 * Tela de cadastro de usuario
	 */
	@RequestMapping("cadastro")
	public String viewCadastro()
	{
		return getView("cadastro");
	}
	
	/**
	 * Formulario de acesso ao sistema
	 */
	@RequestMapping("login/formulario")
	public String viewFormularioAcesso()
	{
		return getView("login/formulario");
	}
	
	/**
	 * Tela de acesso ao sistema
	 */
	@RequestMapping("login/acesso")
	public String viewAcesso()
	{
		return getView("login/acesso");
	}
	
	/**
	 * Executa login no sistema
	 */
	@RequestMapping(value="login/entrar",method=RequestMethod.POST)
	public String executaLogin(Usuario usuario,HttpSession sessao,Model model)
	{
		SessionUtil sessionUtil = new SessionUtil(sessao);
		
		//Verifica se usuario ja possui sessao
		if(sessionUtil.hasUsuario())
			return "redirect:/";
		
		UsuarioUtil usuarioUtil = new UsuarioUtil(usuario, (UsuarioService)super.getService());
		String identificador = super.getGenericAttributeIdentifier();
		
		//Valida login/senha
		if(!usuarioUtil.isUsuarioValido())
		{
			//Forward para o formulario de login com msg de erro
			model.addAttribute(identificador,montaResponse(Response.ERROR, "Login e/ou Senha invalidos", null));
			return "forward:/usuario/login/acesso";
		}
		else
		{
			//Adiciona o usuario na sessao
			usuario = usuarioUtil.getUsuario();
			sessionUtil.addUsuario(usuario);
			
			//Invoca o controller de index
			return "redirect:/";
		}
	}
	
	@Override
	public String getBase() 
	{
		return "usuario/";
	}
	
	@Override
	public String getPathBase() 
	{
		return "/usuario/";
	}
	
	private Response<Object> montaResponse(String status,String message,Object informacao)
	{
		return new Response<Object>(status, message, informacao);
	}
}
