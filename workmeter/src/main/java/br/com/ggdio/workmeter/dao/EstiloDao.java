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
			String tabela = Estilo.class.getAnnotation(Entity.class).name();
			if(!StringUtils.hasText(tabela))
				tabela = "Estilo";
			List<Estilo> resultado = super.hqlQuery("from "+tabela+" where descricao = 'Cerulean'",1);
			return resultado.get(0);
		}
		catch(EntityNotFoundException e)
		{
			throw new EntityNotFoundException("Estilo default foi encontrado");
		}
		catch(Exception e)
		{
			throw new DaoException("Um erro inesperado ocorreu ao buscar o estilo na base de dados", e);
		}
	}
}
