package br.com.ggdio.workmeter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ggdio.workmeter.dao.AbstractDao;

@Service("abstractService")
public abstract class AbstractService<T>
{
	@Autowired
	private AbstractDao<T> abstractDao;
	
	public void adiciona(T entidade)
	{
		abstractDao.saveOrUpdate(entidade);
	}
	
	public List<T> lista()
	{
		return abstractDao.listAll();
	}
}
