package br.com.ggdio.workmeter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.ggdio.workmeter.http.SessionUtil;
import br.com.ggdio.workmeter.model.Usuario;
import br.com.ggdio.workmeter.model.util.UsuarioUtil;
import br.com.ggdio.workmeter.service.UsuarioService;
import br.com.sourcesphere.core.web.generic.controller.response.Response;

@Controller
@RequestMapping("/usuario/")
public final class UsuarioController extends AbstractController<Usuario>
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
	 * Executa login no sistema
	 */
	@RequestMapping(value="login/entrar",method=RequestMethod.POST)
	public String executaLogin(Usuario usuario,HttpSession sessao,Model model){
		SessionUtil sessionUtil = new SessionUtil(sessao);
		
		//Verifica se usuario ja possui sessao
		if(sessionUtil.hasUsuario())
			return "redirect:/";
		
		UsuarioUtil usuarioUtil = new UsuarioUtil(usuario, (UsuarioService)super.getService());
		
		//Valida login/senha
		if(!usuarioUtil.isUsuarioValido())
		{
			//Forward para o formulario de login com msg de erro
			Response<Object> response = super.montaResponseErro("Login e/ou Senha invalidos", null);
			super.preparaResponseErro(response, model);
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
	
	/**
	 * Valida login/senha e responde via ajax
	 * @param usuario - Usuario a tentar login
	 * @param sessao - Sessao do sistema
	 * @return Ajax com a resposta
	 */
	@RequestMapping("login/entrar-ajax")
	public @ResponseBody String executaLoginAjax(Usuario usuario,HttpSession sessao,HttpServletResponse response){
		
		SessionUtil sessionUtil = new SessionUtil(sessao);
		UsuarioUtil usuarioUtil = new UsuarioUtil(usuario, (UsuarioService)super.getService());
		
		//Valida login/senha
		if(!usuarioUtil.isUsuarioValido())
		{
			//Monta a resposta e envia
			response.setStatus(AbstractController.STATUS_UNAUTHORIZED);
			Response<Object> msg = super.montaResponseErro("Login e/ou Senha invalidos", null);
			return super.serializaJson(msg);
		}
		else
		{
			//Adiciona o usuario na sessao e envia resposta
			usuario = usuarioUtil.getUsuario();
			sessionUtil.addUsuario(usuario);
			response.setStatus(AbstractController.STATUS_SUCCESS);
			Response<Object> msg = super.montaResponseSucesso(usuario.getNome()+", seja bem vindo !", null);
			return super.serializaJson(msg);
		}
	}
	
	@RequestMapping("login/sair")
	public String executaLogout(HttpServletRequest request){
		SessionUtil sessionUtil = new SessionUtil(request);
		
		//Limpa a sessao
		sessionUtil.clearSession();
		
		//Invoca o controller de index
		return "redirect:/";
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
	 * Formulario de acesso ao sistema
	 */
	@RequestMapping("login/formulario")
	public String viewFormularioAcesso()
	{
		return getView("login/formulario");
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
}
