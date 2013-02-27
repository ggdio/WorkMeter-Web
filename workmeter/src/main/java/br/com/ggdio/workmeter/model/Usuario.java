package br.com.ggdio.workmeter.model;

import java.util.List;

public final class Usuario 
{
	private Integer id;
	private String login;
	private String senha;
	private String nome;
	private String empresa;
	private List<Hora> horas;
	
	public Integer getId() 
	{
		return id;
	}
	public void setId(Integer id) 
	{
		this.id = id;
	}
	public String getLogin() 
	{
		return login;
	}
	public void setLogin(String login) 
	{
		this.login = login;
	}
	public String getSenha() 
	{
		return senha;
	}
	public void setSenha(String senha) 
	{
		this.senha = senha;
	}
	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	public String getEmpresa() 
	{
		return empresa;
	}
	public void setEmpresa(String empresa) 
	{
		this.empresa = empresa;
	}
	public List<Hora> getHoras() 
	{
		return horas;
	}
	public void setHoras(List<Hora> horas) 
	{
		this.horas = horas;
	}
}
