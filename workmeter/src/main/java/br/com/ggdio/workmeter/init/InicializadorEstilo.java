package br.com.ggdio.workmeter.init;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.ggdio.workmeter.dao.EstiloDao;
import br.com.ggdio.workmeter.model.Estilo;

/**
 * Inicializador de estilos default
 * @author Guilherme Dio
 *
 */
public class InicializadorEstilo 
{
	private static final Logger log = Logger.getLogger(InicializadorEstilo.class);
	
	@SuppressWarnings("serial")
	private static final List<Estilo> estilos = new ArrayList<Estilo>()
	{{
		add(new Estilo("Default","/webresources/twitter-bootstrap/css/bootstrap-cerulean.css"));
		add(new Estilo("Amelia","/webresources/twitter-bootstrap/css/bootstrap-amelia.css"));
		add(new Estilo("Cyborg","/webresources/twitter-bootstrap/css/bootstrap-cyborg.css"));
		add(new Estilo("Readable","/webresources/twitter-bootstrap/css/bootstrap-readable.css"));
		add(new Estilo("Responsive","/webresources/twitter-bootstrap/css/bootstrap-responsive.css"));
		add(new Estilo("Simplex","/webresources/twitter-bootstrap/css/bootstrap-simplex.css"));
		add(new Estilo("Slate","/webresources/twitter-bootstrap/css/bootstrap-slate.css"));
		add(new Estilo("Spacelab","/webresources/twitter-bootstrap/css/bootstrap-spacelab.css"));
		add(new Estilo("Spruce","/webresources/twitter-bootstrap/css/bootstrap-spruce.css"));
		add(new Estilo("Superhero","/webresources/twitter-bootstrap/css/bootstrap-superhero.css"));
		add(new Estilo("United","/webresources/twitter-bootstrap/css/bootstrap-united.css"));
	}};
	
	public static void init(EstiloDao dao) throws InicializadorEstiloException
	{
		if(isEstilosSalvos(dao))
		{
			log.info("InicializadorEstilos: O sistema j� possu� os estilos default cadastrados");
			return;
		}
		
		log.info("InicializadorEstilos: Inicializando os estilos default do sistema");
		try
		{
			saveEstilos(dao);
		}
		catch(Exception e)
		{
			throw new InicializadorEstiloException("N�o foi possivel inicializar os estilos default do sistema: "+e.getMessage());
		}
		log.info("InicializadorEstilos: Inicializa��o dos estilos default conclu�da com sucesso");
	}
	
	private static Boolean isEstilosSalvos(EstiloDao dao)
	{
		List<Estilo> retorno = dao.listAll();
		return retorno.size() >= estilos.size();
	}
	
	private static void saveEstilos(EstiloDao dao)
	{
		for(Estilo estilo : estilos)
		{
			log.info("InicializadorEstilos: Gravando o estilo '"+estilo.getDescricao()+"'");
			dao.saveOrUpdate(estilo);
		}
	}
}
