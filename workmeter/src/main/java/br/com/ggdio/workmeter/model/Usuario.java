package br.com.ggdio.workmeter.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

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
	private String email;
	private String senha;
	private String nome;
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private DateTime nascimento;
	private String empresa;
	@OneToMany
	private List<Hora> horas;
	@OneToOne(cascade=CascadeType.ALL)
	private Preferencia preferencia;
	private Boolean ativo;
	
	public Usuario() 
	{
		
	}
	
	public Usuario(String login,String senha)
	{
		setEmail(login);
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
		this.id = id;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		assertion.notEmpty(email);
		this.email = email;
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
	public DateTime getNascimento() 
	{
		return nascimento;
	}
	public void setNascimento(DateTime nascimento) 
	{
		assertion.notNull(nascimento);
		this.nascimento = nascimento;
	}
	public String getEmpresa() 
	{
		return empresa;
	}
	public void setEmpresa(String empresa) 
	{
		assertion.notEmpty(empresa);
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
	public Preferencia getPreferencia() 
	{
		return preferencia;
	}
	public void setPreferencia(Preferencia preferencia) 
	{
		this.preferencia = preferencia;
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
