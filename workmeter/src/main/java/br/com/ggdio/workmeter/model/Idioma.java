package br.com.ggdio.workmeter.model;

import java.util.Locale;

public enum Idioma 
{
	PORTUGUES_BR("pt","BR"),
	INGLES("en","US"),
	ESPANHOL("es","ES");
	
	
	private Idioma(String bundle,String pais)
	{
		this.bundle = bundle;
		this.pais = pais;
	}
	
	private final String bundle;
	private final String pais;
	
	public String getBundle() 
	{
		return bundle;
	}
	
	public String getPais() 
	{
		return pais;
	}
	
	public Locale getLocale()
	{
		return new Locale(bundle,pais);
	}
}
