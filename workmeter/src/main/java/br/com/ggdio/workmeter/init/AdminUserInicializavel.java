package br.com.ggdio.workmeter.init;

import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import br.com.ggdio.workmeter.dao.EstiloDao;
import br.com.ggdio.workmeter.dao.UsuarioDao;
import br.com.ggdio.workmeter.model.Idioma;
import br.com.ggdio.workmeter.model.Preferencia;
import br.com.ggdio.workmeter.model.Usuario;
import br.com.sourcesphere.core.web.generic.dao.MasterDao;

/**
 * Inicializador de usuarios fixos
 * @author Guilherme Dio
 *
 */
public class AdminUserInicializavel implements Inicializavel
{
	private static final Logger log = Logger.getLogger(AdminUserInicializavel.class);
	
	private static String credentials = new String("admin|4cc5b2b967bc2cd00fba727d9b980d45|Admin");
	
	public void init(MasterDao<?>...daos){
		log.info("InicializadorUsuario: Inicializando a insercao dos usuarios fixos no sistema");
		if(daos.length != 2) {
			log.warn("InicializadorUsuario: Finalizando, pois a quantidade de parametros esta incorreta, deve ser dois");
			return;
		}
		if(daos[0] instanceof EstiloDao == false) {
			log.warn("InicializadorUsuario: Finalizando, pois o primeiro parametro nao se trata de um estiloDao");
			return;
		}
		if(daos[1] instanceof UsuarioDao == false) {
			log.warn("InicializadorUsuario: Finalizando, pois o segundo parametro nao se trata de um usuarioDao");
			return;
		}
		try{
			EstiloDao estiloDao = (EstiloDao) daos[0];
			UsuarioDao usuarioDao = (UsuarioDao) daos[1];
			if(isUsuariosSalvos(usuarioDao)){
				log.info("InicializadorEstilos: O sistema ja possui o admin definido.");
				return;
			}
			StringTokenizer token = new StringTokenizer(credentials,"|");
			Usuario usuario = new Usuario(token.nextToken(), token.nextToken());
			usuario.setNome(token.nextToken());
			usuario.setAtivo(true);
			usuario.setEmpresa("sourcesphere");
			usuario.setNascimento(DateTime.now());
			usuario.setPreferencia(new Preferencia(estiloDao.getEstiloDefault(),Idioma.PORTUGUES_BR));
			usuarioDao.saveOrUpdate(usuario);
			log.info("InicializadorEstilos: Usuario 'admin' configurado com sucesso !");
		}
		catch(Exception e){
			log.error("Ocorreu um erro ao inicializar o usuario 'admin'",e);
		}
	}

	private static boolean isUsuariosSalvos(UsuarioDao dao) {
		try{
			StringTokenizer token = new StringTokenizer(credentials,"|");
			dao.getUsuarioPorLoginESenha(token.nextToken(), token.nextToken());
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
}
