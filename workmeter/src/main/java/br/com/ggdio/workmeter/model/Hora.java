package br.com.ggdio.workmeter.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import br.com.sourcesphere.core.util.Assert;

@Entity
//@SequenceGenerator(name="hora_seq",sequenceName="hora_id_seq",allocationSize=1)
public final class Hora implements Comparable<Hora>
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="hora_seq")
	private Long id;
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime registro;
	@Enumerated(EnumType.STRING)
	private TipoHora tipo;
	@OneToOne
	private Usuario usuario;
	
	/**
	 * Assert para segurança
	 */
	@Transient
	private final Assert assertion = new Assert();
	
	public Hora() 
	{
		
	}
	
	public Hora(DateTime registro,TipoHora tipo,Usuario usuario)
	{
		setRegistro(registro);
		setTipo(tipo);
		setUsuario(usuario);
	}
	
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
	public Usuario getUsuario()
	{
		return usuario;
	}
	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}
	
	@Override
	public int compareTo(Hora outro)
	{
		return getRegistro().compareTo(outro.getRegistro());
	}
}
