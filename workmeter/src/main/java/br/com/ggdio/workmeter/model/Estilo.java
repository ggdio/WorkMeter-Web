package br.com.ggdio.workmeter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Where;

import br.com.sourcesphere.core.util.EqualsUtil;

@Entity
@Where(clause="ativo = 't'")
public class Estilo 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private String url;
	private Boolean ativo;
	
	public Estilo() 
	{
	}
	
	public Estilo(String descricao,String url)
	{
		setDescricao(descricao);
		setUrl(url);
	}
	
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public String getDescricao() 
	{
		return descricao;
	}
	public void setDescricao(String descricao) 
	{
		this.descricao = descricao;
	}
	public String getUrl() 
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}
	public Boolean isAtivo()
	{
		return ativo;
	}
	public void setAtivo(Boolean ativo) 
	{
		this.ativo = ativo;
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		return new EqualsUtil(this).isEquals(obj);
	}
}
