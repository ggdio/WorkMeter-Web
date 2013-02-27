package br.com.ggdio.workmeter.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.stereotype.Repository;

import br.com.ggdio.workmeter.model.Hora;

@Repository
public final class HoraDao 
{
	@Autowired
	private HibernateTransactionManager transactionManager;
	
	public Hora saveOrUpdate(Hora hora)
	{
		Transaction transaction = null;
		try 
		{
			transaction = this.getSession().beginTransaction();
			this.getSession().saveOrUpdate(hora);
			transaction.commit();
		} 
		catch (Exception e) 
		{
			System.out.println("erro save/update "+e.getMessage());
		} 
		return hora;
	}
	
	private Session getSession()
	{
		return transactionManager.getSessionFactory().getCurrentSession();
	}
}
