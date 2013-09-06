package br.com.ggdio.workmeter.dao;

import java.util.List;

import javax.persistence.Entity;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.ggdio.workmeter.model.Estilo;
import br.com.sourcesphere.core.util.StringUtils;
import br.com.sourcesphere.core.web.generic.dao.MasterDao;
import br.com.sourcesphere.core.web.generic.dao.exception.DaoException;
import br.com.sourcesphere.core.web.generic.dao.exception.EntityNotFoundException;

@Repository("estiloDao")
public class EstiloDao extends MasterDao<Estilo> 
{
	@Autowired
	public EstiloDao(SessionFactory sessionFactory) 
	{
		super(sessionFactory);
	}
	
	public Estilo getEstiloDefault()
	{
		try
		{
			return getEstiloPorDescricao("Default");
		}
		catch(EntityNotFoundException e)
		{
			throw new EntityNotFoundException("O estilo default nao foi encontrado na base, provavelmente nao foi cadastrado corretamente");
		}
	}
	
	public Estilo getEstiloPorDescricao(String descricao)
	{
		try
		{
			String tabela = Estilo.class.getAnnotation(Entity.class).name();
			if(!StringUtils.hasText(tabela))
				tabela = "Estilo";
			List<Estilo> resultado = super.hqlQuery("from "+tabela+" where str(descricao) = '"+descricao+"'",1);
			return resultado.get(0);
		}
		catch(EntityNotFoundException e)
		{
			throw new EntityNotFoundException("Estilo "+descricao+" nao encontrado");
		}
		catch(DaoException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw new DaoException("Um erro inesperado ocorreu ao buscar o estilo "+descricao+" na base de dados", e);
		}
	}
}
