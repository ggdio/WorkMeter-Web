package br.com.ggdio.workmeter.service;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ggdio.workmeter.dao.HoraDao;
import br.com.ggdio.workmeter.model.Hora;
import br.com.ggdio.workmeter.model.TipoHora;
import br.com.ggdio.workmeter.model.Usuario;
import br.com.ggdio.workmeter.service.strategy.ValidadorHora;
import br.com.sourcesphere.core.web.generic.dao.exception.DaoException;
import br.com.sourcesphere.core.web.generic.dao.exception.EntityAlreadyExistException;
import br.com.sourcesphere.core.web.generic.dao.exception.EntityNotFoundException;
import br.com.sourcesphere.core.web.generic.service.MasterService;
import br.com.sourcesphere.core.web.generic.service.exception.ServiceException;

@Service("horaService")
public final class HoraService extends MasterService<Hora>
{
	@Autowired
	public HoraService(HoraDao horaDao) 
	{
		super(horaDao);
	}

	public Hora getUltimaDeclarada(Usuario usuario) 
	{
		HoraDao dao = (HoraDao) super.getDao();
		try
		{
			return dao.getUltimaDeclarada(usuario);
		}
		catch(EntityNotFoundException e)
		{
			log.warn("Nenhuma hora foi declarada pelo usuario '"+usuario.getNome()+"'");
			throw e;
		}
		catch(DaoException e)
		{
			log.error(e.getMessage(), e);
			throw e;
		}
		catch(Exception e)
		{
			log.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}
	
	private void declararHora(Hora hora)
	{
		if(hora.getUsuario() == null) throw new ServiceException("A hora deve estar vinculada a um usuario");
		HoraDao dao = (HoraDao) super.getDao();
		try
		{
			dao.saveOrUpdate(hora);
		}
		catch(EntityAlreadyExistException e)
		{
			log.warn(e.getMessage());
			throw e;
		}
		catch(DaoException e)
		{
			log.error(e.getMessage(),e);
			throw e;
		}
		catch(Exception e)
		{
			log.error(e.getMessage(),e);
			throw new ServiceException(e);
		}
	}
	
	public void iniciarDia(Usuario usuario)
	{
		Hora hora = new Hora(DateTime.now(), TipoHora.INICIO, usuario);
		validaHora(hora);
		declararHora(hora);
	}
	
	public void validaHora(Hora hora)
	{
		//Valida a hora(exception lancada caso esteja irregular)
		Hora ultima = getUltimaDeclarada(hora.getUsuario());
		ValidadorHora validador = hora.getTipo().getValidadorHora();
		validador.validaHora(hora, ultima);
	}
}
