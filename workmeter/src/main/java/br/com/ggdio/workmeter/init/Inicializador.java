package br.com.ggdio.workmeter.init;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.ggdio.workmeter.dao.EstiloDao;

/**
 * Inicializador do sistema
 * @author Guilherme Dio
 *
 */
public class Inicializador 
{
	private SessionFactory sessionFactory;
	
	private Logger log = Logger.getLogger(Inicializador.class);
	
	@Autowired
	public Inicializador(SessionFactory sessionFactory) 
	{
		setSessionFactory(sessionFactory);
	}
	
	public void init()
	{
		try
		{
			InicializadorEstilo.init(new EstiloDao(sessionFactory));
		}
		catch(Exception e)
		{
			log.warn("Ocorreu um problema durante a inicialização: "+e.getMessage());
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
}
