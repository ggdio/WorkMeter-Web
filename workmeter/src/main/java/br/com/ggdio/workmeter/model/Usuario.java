package br.com.ggdio.workmeter.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import br.com.sourcesphere.core.util.Assert;

@Entity
@SQLDelete(sql="UPDATE usuario SET ativo = false where id = ?")
@Where(clause="ativo = 't'")
public final class Usuario 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(unique=true)
	private String login;
	private String senha;
	private String nome;
	private String empresa;
	@OneToMany
	private List<Hora> horas;
	private Boolean ativo;
	
	public Usuario() 
	{
		setAtivo(true);
	}
	
	public Usuario(String login,String senha)
	{
		setLogin(login);
		setSenha(senha);
	}
	
	/**
	 * Assert para segurança
	 */
	@Transient
	private final Assert assertion = new Assert();
	
	public Long getId() 
	{
		return id;
	}
	public void setId(Long id) 
	{
		assertion.notNull(id);
		this.id = id;
	}
	public String getLogin() 
	{
		return login;
	}
	public void setLogin(String login) 
	{
		assertion.notEmpty(login);
		this.login = login;
	}
	public String getSenha() 
	{
		return senha;
	}
	public void setSenha(String senha) 
	{
		assertion.notEmpty(senha);
		this.senha = senha;
	}
	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		assertion.notEmpty(nome);
		this.nome = nome;
	}
	public String getEmpresa() 
	{
		assertion.notEmpty(empresa);
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
		assertion.noNullElements(horas.toArray());
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
