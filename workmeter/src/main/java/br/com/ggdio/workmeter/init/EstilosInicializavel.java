package br.com.ggdio.workmeter.init;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.ggdio.workmeter.dao.EstiloDao;
import br.com.ggdio.workmeter.model.Estilo;
import br.com.sourcesphere.core.web.generic.dao.MasterDao;

/**
 * Inicializador de estilos default
 * @author Guilherme Dio
 *
 */
public class EstilosInicializavel implements Inicializavel 
{
	private static final Logger log = Logger.getLogger(EstilosInicializavel.class);
	
	@SuppressWarnings("serial")
	private static final List<Estilo> estilos = new ArrayList<Estilo>()
	{{
		add(new Estilo("Default","/resources/css/default.css"));
		add(new Estilo("Amelia","/webresources/twitter-bootstrap/css/bootstrap-amelia.css"));
		add(new Estilo("Cyborg","/webresources/twitter-bootstrap/css/bootstrap-cyborg.css"));
		add(new Estilo("Readable","/webresources/twitter-bootstrap/css/bootstrap-readable.css"));
		add(new Estilo("Simplex","/webresources/twitter-bootstrap/css/bootstrap-simplex.css"));
		add(new Estilo("Slate","/webresources/twitter-bootstrap/css/bootstrap-slate.css"));
		add(new Estilo("Spacelab","/webresources/twitter-bootstrap/css/bootstrap-spacelab.css"));
		add(new Estilo("Spruce","/webresources/twitter-bootstrap/css/bootstrap-spruce.css"));
		add(new Estilo("Superhero","/webresources/twitter-bootstrap/css/bootstrap-superhero.css"));
		add(new Estilo("United","/webresources/twitter-bootstrap/css/bootstrap-united.css"));
	}};
	
	public void init(MasterDao<?>...daos)
	{
		if(daos[0] instanceof EstiloDao == false) {
			log.warn("InicializadorEstilos: Finalizando pois o parametro nao se trata de um estiloDao");
		}
		EstiloDao dao = (EstiloDao) daos[0];
		if(isEstilosSalvos(dao))
		{
			log.info("InicializadorEstilos: O sistema ja possui os estilos default cadastrados");
			return;
		}
		
		log.info("InicializadorEstilos: Inicializando os estilos default do sistema");
		try
		{
			saveEstilos(dao);
		}
		catch(Exception e)
		{
			log.error("Nao foi possivel inicializar os estilos dafult do sistema: ",e);
		}
		log.info("InicializadorEstilos: Inicializacaoo dos estilos default concluida com sucesso");
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
