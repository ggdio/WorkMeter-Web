package br.com.ggdio.workmeter.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Preferencia 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Estilo estilo;
	
	@Enumerated(EnumType.STRING)
	private Idioma idioma;
	
	public Long getId() 
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public Estilo getEstilo() 
	{
		return estilo;
	}
	public void setEstilo(Estilo estilo) 
	{
		this.estilo = estilo;
	}
	public Idioma getIdioma()
	{
		return idioma;
	}
	public void setIdioma(Idioma idioma)
	{
		this.idioma = idioma;
	}	
}
