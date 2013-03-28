package br.com.ggdio.workmeter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ggdio.workmeter.http.SessionUtil;
import br.com.ggdio.workmeter.model.Usuario;
import br.com.ggdio.workmeter.model.util.UsuarioUtil;
import br.com.ggdio.workmeter.service.UsuarioService;
import br.com.sourcesphere.core.web.generic.controller.MasterController;
import br.com.sourcesphere.core.web.generic.controller.response.Response;

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
	@RequestMapping(value="criar",method=RequestMethod.POST)
	public String adicionar(HttpSession sessao,Usuario usuario)
	{
		super.add(usuario);
		
		SessionUtil sessionUtil = new SessionUtil(sessao);
		sessionUtil.addUsuario(usuario);
		
		return "redirect:/";
	}
	
	/**
	 * Altera um usuario
	 */
	@RequestMapping(value="atualizar",method=RequestMethod.POST)
	public void atualizar(Usuario usuario)
	{
		super.alter(usuario);
	}
	
	/**
	 * Remove um usuario
	 */
	@RequestMapping(value="remover",method=RequestMethod.POST)
	public void deletar(Usuario usuario)
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
	 * Popup com Formulario de cadastro de usuario
	 */
	@RequestMapping("popup-formulario")
	public String viewPopupFormularioCadastro()
	{
		return getView("popupFormulario");
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
	 * Popup com Formulario de acesso ao sistema
	 */
	@RequestMapping("login/popup-formulario")
	public String viewPopupFormularioAcesso()
	{
		return getView("login/popupFormulario");
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
	 * Tela de dados do usuario
	 */
	@RequestMapping("dados")
	public String viewDadosUsuario(HttpSession sessao,Model model)
	{
		return getView("dados");
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
		String identificador = getGenericAttributeIdentifier();
		
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
	
	@RequestMapping("login/sair")
	public String executaLogout(HttpServletRequest request)
	{
		SessionUtil sessionUtil = new SessionUtil(request);
		
		//Limpa a sessao
		sessionUtil.clearSession();
		
		//Invoca o controller de index
		return "redirect:/";
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
	
	@Override
	public String getGenericAttributeIdentifier() 
	{
		return "responseLogin";
	}
	
	private Response<Object> montaResponse(String status,String message,Object informacao)
	{
		return new Response<Object>(status, message, informacao);
	}
}
