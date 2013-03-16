package br.com.ggdio.workmeter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ggdio.workmeter.dao.EstiloDao;
import br.com.ggdio.workmeter.model.Estilo;
import br.com.sourcesphere.core.web.generic.dao.exception.DaoException;
import br.com.sourcesphere.core.web.generic.dao.exception.EntityNotFoundException;
import br.com.sourcesphere.core.web.generic.service.MasterService;
import br.com.sourcesphere.core.web.generic.service.exception.ServiceException;

@Service("estiloService")
public class EstiloService extends MasterService<Estilo>
{
	@Autowired
	public EstiloService(EstiloDao estiloDao) 
	{
		super(estiloDao);
	}
	
	public Estilo getEstiloDefault()
	{
		EstiloDao dao = (EstiloDao) super.getDao();
		try
		{
			return dao.getEstiloDefault();
		}
		catch(EntityNotFoundException e)
		{
			log.warn(e.getMessage(), e);
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
	
	public Estilo getEstiloPorDescricao(String descricao)
	{
		EstiloDao dao = (EstiloDao) super.getDao();
		try
		{
			return dao.getEstiloPorDescricao(descricao);
		}
		catch(EntityNotFoundException e)
		{
			log.warn(e.getMessage(), e);
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
}
