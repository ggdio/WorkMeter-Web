package br.com.ggdio.workmeter.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
//@SequenceGenerator(name="preferencia_seq",sequenceName="preferencia_id_seq",allocationSize=1)
public class Preferencia 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="preferencia_seq")
	private Long id;
	
	@OneToOne
	private Estilo estilo;
	
	@Enumerated(EnumType.STRING)
	private Idioma idioma;
	
	public Preferencia() {
		// TODO Auto-generated constructor stub
	}
	
	public Preferencia(Estilo estilo,Idioma idioma) {
		this.setEstilo(estilo);
		this.setIdioma(idioma);
	}
	
	
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
