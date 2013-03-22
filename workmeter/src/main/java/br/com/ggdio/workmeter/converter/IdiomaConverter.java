package br.com.ggdio.workmeter.converter;
import java.io.Serializable;

import javax.persistence.EnumType;

import br.com.ggdio.workmeter.model.Idioma;
import br.com.sourcesphere.core.converter.Converter;


public class IdiomaConverter implements Converter<Idioma, String> 
{
	@Override
	public String convertTo(Idioma objeto) 
	{
		return objeto.toString();
	}

	@Override
	public Idioma convertFrom(String objeto) 
	{
		return EnumType.valueOf(Idioma.class, objeto);
	}
	
	@Override
	public Serializable getValue(Idioma objeto) 
	{
		return convertTo(objeto);
	}
}
