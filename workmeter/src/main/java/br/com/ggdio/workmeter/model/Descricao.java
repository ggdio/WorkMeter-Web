package br.com.ggdio.workmeter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import br.com.ggdio.workmeter.util.Assert;

@Entity
public class Descricao 
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Hora horaInicial;
	@OneToOne
	private Hora horaFinal;
	private String cliente;
	private String descricao;
	
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
	public Hora getHoraInicial()
	{
		return horaInicial;
	}
	public void setHoraInicial(Hora horaInicial) 
	{
		assertion.notNull(horaInicial);
		this.horaInicial = horaInicial;
	}
	public Hora getHoraFinal() 
	{
		return horaFinal;
	}
	public void setHoraFinal(Hora horaFinal) 
	{
		assertion.notNull(horaFinal);
		this.horaFinal = horaFinal;
	}
	public String getCliente() 
	{
		return cliente;
	}
	public void setCliente(String cliente) 
	{
		assertion.notEmpty(cliente);
		this.cliente = cliente;
	}
	public String getDescricao() 
	{
		return descricao;
	}
	public void setDescricao(String descricao) 
	{
		assertion.notEmpty(descricao);
		this.descricao = descricao;
	}
}
