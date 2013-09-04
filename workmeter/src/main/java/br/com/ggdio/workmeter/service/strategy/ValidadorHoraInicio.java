package br.com.ggdio.workmeter.service.strategy;

import org.joda.time.DateTime;
import org.joda.time.Days;

import br.com.ggdio.workmeter.model.Hora;
import br.com.ggdio.workmeter.model.TipoHora;
import br.com.sourcesphere.core.web.generic.service.exception.ServiceException;

public class ValidadorHoraInicio implements ValidadorHora {

	@Override
	public void validaHora(Hora hora,Hora ultima) {
		Integer dias = Days.daysBetween(ultima.getRegistro(), DateTime.now()).getDays();
		if(dias == 0)
		{
			if(ultima.getTipo() == TipoHora.FIM)
			{
				throw new ServiceException("O dia de trabalho já foi finalizado por hoje, aguarde até amanhã para poder iniciar");
			}
			throw new ServiceException("O dia de trabalho já foi iniciado");
		}
	}

}
