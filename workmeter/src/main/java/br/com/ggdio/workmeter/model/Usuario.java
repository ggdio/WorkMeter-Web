package br.com.ggdio.workmeter.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@SQLDelete(sql="UPDATE usuario SET ativo = false where id = ?")
@Where(clause="ativo = true")
public final class Usuario 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String login;
	private String senha;
	private String nome;
	private String empresa;
	@OneToMany
	private List<Hora> horas;
	private Boolean ativo;
	
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
	public Boolean isAtivo()
	{
		return this.ativo;
	}
	public void setAtivo(Boolean ativo)
	{
		this.ativo = ativo;
	}
}
