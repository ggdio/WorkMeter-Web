package br.com.ggdio.workmeter.init;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.ggdio.workmeter.dao.EstiloDao;
import br.com.ggdio.workmeter.dao.UsuarioDao;

/**
 * Inicializador do sistema
 * @author Guilherme Dio
 *
 */
public class Inicializador 
{
	private SessionFactory sessionFactory;
	private List<Inicializavel> inicializaveis;
	
	private Logger log = Logger.getLogger(Inicializador.class);
	
	@Autowired
	public Inicializador(SessionFactory sessionFactory,List<Inicializavel> inicializaveis) 
	{
		setSessionFactory(sessionFactory);
		setInicializaveis(inicializaveis);
	}
	
	public void init()
	{
		EstiloDao estiloDao = new EstiloDao(sessionFactory);
		UsuarioDao usuarioDao = new UsuarioDao(sessionFactory);
		try
		{
			for(Inicializavel init : inicializaveis)
				init.init(estiloDao,usuarioDao);
		}
		catch(Exception e)
		{
			log.warn("Ocorreu um problema durante a inicialização: "+e.getMessage());
		}
		finally{
			estiloDao = null;
			usuarioDao = null;
		}
	}
	
	public SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public void setInicializaveis(List<Inicializavel> inicializaveis){
		this.inicializaveis = inicializaveis;
	}
}
