package br.com.ggdio.workmeter.model;

import java.util.Locale;

import br.com.sourcesphere.core.util.Messager;
import br.com.sourcesphere.core.util.StringUtils;

public enum Idioma 
{
	PORTUGUES_BR("pt","BR","sistema.idioma.portuguesbr"),
	INGLES("en","US", "sistema.idioma.ingles"),
	ESPANHOL("es","ES", "sistema.idioma.espanhol");
	
	
	private Idioma(String bundle,String pais,String i18nKey)
	{
		this.bundle = bundle;
		this.pais = pais;
		this.i18nKey = i18nKey;
	}
	
	private final String bundle;
	private final String pais;
	private final String i18nKey;
	
	public static Idioma getValorDe(String valor)
	{
		Idioma idioma = null;
		if(!(StringUtils.hasText(valor)) || (idioma = Idioma.valueOf(valor)) == null)
			idioma = Idioma.PORTUGUES_BR;
		return idioma;
	}
	
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
	
	public String getNomeLocal(){
		return new Messager("messages").getMessage(i18nKey);
	}
	
	public String getNome(){
		return this.toString();
	}
}
