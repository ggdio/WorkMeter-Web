package br.com.ggdio.workmeter.converter;
import java.io.Serializable;

import br.com.ggdio.workmeter.model.Estilo;
import br.com.sourcesphere.core.converter.Converter;


public class EstiloConverter implements Converter<Estilo, String> 
{

	@Override
	public String convertTo(Estilo objeto) 
	{
		return objeto.getDescricao();
	}

	@Override
	public Estilo convertFrom(String objeto) 
	{
		Estilo estilo = new Estilo();
		estilo.setDescricao(objeto);
		return estilo;
	}
	
	public Serializable getValue(Estilo objeto) 
	{
		return objeto.getId().longValue();
	}

}
