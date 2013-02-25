package br.com.ggdio.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
public final class Hora 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime registro;
	@Enumerated(EnumType.STRING)
	private TipoHora tipo;
	
	public Integer getId() 
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public DateTime getRegistro()
	{
		return registro;
	}
	public void setRegistro(DateTime registro) 
	{
		this.registro = registro;
	}
	public TipoHora getTipo() 
	{
		return tipo;
	}
	public void setTipo(TipoHora tipo) 
	{
		this.tipo = tipo;
	}
}
