package br.com.ggdio.workmeter.controller;

import org.apache.log4j.Logger;

public abstract class MasterController 
{
	public static final Logger log = Logger.getLogger(MasterController.class.getName());
	
	/**
	 * Define a base de views especifica do controller
	 * @return Base de diretorio das views
	 */
	public String getBase()
	{
		return "/";
	}
	
	/**
	 * Recupera a view especifica a partir da base de diretorio
	 * @param view - Nome da view(Ex: index.jsp)
	 * @return String
	 */
	public String getView(String view)
	{
		return getBase()+view;
	}
}
