package br.com.ggdio.workmeter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Descricao 
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@OneToOne
	private Hora horaInicial;
	@OneToOne
	private Hora horaFinal;
	private String cliente;
	private String descricao;
	
	public Integer getId() 
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Hora getHoraInicial()
	{
		return horaInicial;
	}
	public void setHoraInicial(Hora horaInicial) 
	{
		this.horaInicial = horaInicial;
	}
	public Hora getHoraFinal() 
	{
		return horaFinal;
	}
	public void setHoraFinal(Hora horaFinal) 
	{
		this.horaFinal = horaFinal;
	}
	public String getCliente() 
	{
		return cliente;
	}
	public void setCliente(String cliente) 
	{
		this.cliente = cliente;
	}
	public String getDescricao() 
	{
		return descricao;
	}
	public void setDescricao(String descricao) 
	{
		this.descricao = descricao;
	}
}
