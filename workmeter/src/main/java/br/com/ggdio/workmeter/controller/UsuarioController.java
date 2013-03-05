package br.com.ggdio.workmeter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.ggdio.workmeter.model.Usuario;
import br.com.ggdio.workmeter.model.util.UsuarioUtil;
import br.com.ggdio.workmeter.service.UsuarioService;

@Controller
@RequestMapping("/usuario/")
public final class UsuarioController extends MasterController<Usuario>
{
	@Autowired
	public UsuarioController(UsuarioService usuarioService) 
	{
		super(usuarioService);
	}
	
	@Override
	@RequestMapping(value="criar",method=RequestMethod.POST)
	public void add(Usuario usuario)
	{
		super.add(usuario);
	}
	
	@Override
	@RequestMapping(value="alterar",method=RequestMethod.POST)
	public void alter(Usuario usuario)
	{
		super.alter(usuario);
	}
	
	@Override
	@RequestMapping(value="remover",method=RequestMethod.POST)
	public void delete(Usuario usuario)
	{
		super.delete(usuario);
	}
	
	@RequestMapping("formulario")
	public String viewFormulario()
	{
		return getView("formulario");
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
}
