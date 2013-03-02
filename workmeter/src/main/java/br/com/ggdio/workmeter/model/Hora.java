package br.com.ggdio.workmeter.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import br.com.ggdio.workmeter.util.Assert;

@Entity
public final class Hora
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime registro;
	@Enumerated(EnumType.STRING)
	private TipoHora tipo;
	
	/**
	 * Assert para segurança
	 */
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
	public DateTime getRegistro()
	{
		return registro;
	}
	public void setRegistro(DateTime registro) 
	{
		assertion.notNull(registro);
		this.registro = registro;
	}
	public TipoHora getTipo() 
	{
		return tipo;
	}
	public void setTipo(TipoHora tipo) 
	{
		assertion.notNull(tipo);
		this.tipo = tipo;
	}
}
