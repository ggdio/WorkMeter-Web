package br.com.ggdio.workmeter.service;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ggdio.workmeter.dao.HoraDao;
import br.com.ggdio.workmeter.model.Hora;
import br.com.ggdio.workmeter.model.TipoHora;
import br.com.ggdio.workmeter.model.Usuario;
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
	
	public void declararHora(Hora hora)
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
		Hora ultima = getUltimaDeclarada(usuario);
		DateTime hoje = DateTime.now();
		Integer dias = Days.daysBetween(ultima.getRegistro(), hoje).getDays();
		if(dias == 0)
			throw new ServiceException("O dia de trabalho já foi iniciado");
		declararHora(new Hora(hoje, TipoHora.INICIO, usuario));
	}
	
	public void validaHora(Hora hora)
	{
		switch(hora.getTipo())
		{
			case INICIO:
				validaHoraInicio(hora);
				break;
			case PAUSA:
				validaHoraPausa(hora);
				break;
			case RETORNO:
				validaHoraRetorno(hora);
				break;
			case FIM:
				validaHoraFim(hora);
				break;
		}
	}
	
	public void validaHoraInicio(Hora hora)
	{
		Hora ultima = getUltimaDeclarada(hora.getUsuario());
		DateTime hoje = DateTime.now();
		Integer dias = Days.daysBetween(ultima.getRegistro(), hoje).getDays();
		if(dias == 0)
		{
			if(ultima.getTipo() == TipoHora.FIM)
			{
				throw new ServiceException("O dia de trabalho já foi finalizado por hoje, aguarde até amanhã para poder iniciar");
			}
			throw new ServiceException("O dia de trabalho já foi iniciado");
		}
	}
	
	public void validaHoraRetorno(Hora hora)
	{
		Hora ultima = getUltimaDeclarada(hora.getUsuario());
		if(ultima.getTipo() == TipoHora.FIM)
			throw new ServiceException("O dia de trabalho ainda não foi iniciado");
		else if(ultima.getTipo() != TipoHora.PAUSA)
			throw new ServiceException("O trabalho ainda não foi pausado");
	}
	
	public void validaHoraPausa(Hora hora)
	{
		Hora ultima = getUltimaDeclarada(hora.getUsuario());
		if(ultima.getTipo() == TipoHora.FIM)
			throw new ServiceException("O dia de trabalho ainda não foi iniciado");
		else if(ultima.getTipo() != TipoHora.RETORNO)
			throw new ServiceException("O trabalho ainda não foi retomado");
	}
	
	public void validaHoraFim(Hora hora)
	{
		Hora ultima = getUltimaDeclarada(hora.getUsuario());
		DateTime hoje = DateTime.now();
		Integer dias = Days.daysBetween(ultima.getRegistro(), hoje).getDays();
		if(dias > 0)
			throw new ServiceException("O dia de trabalho ainda não foi iniciado");
		else if(ultima.getTipo() == TipoHora.FIM)
			throw new ServiceException("O dia de trabalho já foi finalizado");
	}
}
