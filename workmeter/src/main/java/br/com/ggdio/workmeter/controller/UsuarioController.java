package br.com.ggdio.workmeter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ggdio.workmeter.model.Usuario;
import br.com.ggdio.workmeter.service.UsuarioService;

@Controller
@RequestMapping("/usuario/")
public final class UsuarioController extends DefaultController<Usuario>
{
	@Autowired
	public UsuarioController(UsuarioService usuarioService) 
	{
		super(usuarioService);
	}
	
	@Override
	@RequestMapping(value="criar",method=RequestMethod.POST)
	public void adicionar(Usuario usuario)
	{
		super.adicionar(usuario);
	}
	
	@Override
	@RequestMapping(value="alterar",method=RequestMethod.POST)
	public void alterar(Usuario usuario)
	{
		super.alterar(usuario);
	}
	
	@Override
	@RequestMapping(value="remover",method=RequestMethod.POST)
	public void remover(Usuario usuario)
	{
		super.remover(usuario);
	}
	
	@Override
	public String getBase() 
	{
		return "usuario/";
	}
}
