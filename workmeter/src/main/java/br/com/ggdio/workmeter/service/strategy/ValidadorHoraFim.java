package br.com.ggdio.workmeter.service.strategy;

import org.joda.time.DateTime;
import org.joda.time.Days;

import br.com.ggdio.workmeter.model.Hora;
import br.com.ggdio.workmeter.model.TipoHora;
import br.com.sourcesphere.core.web.generic.service.exception.ServiceException;

public class ValidadorHoraFim implements ValidadorHora {

	@Override
	public void validaHora(Hora hora, Hora ultima) {
		Integer dias = Days.daysBetween(ultima.getRegistro(), DateTime.now()).getDays();
		if(dias > 0)
			throw new ServiceException("O dia de trabalho ainda não foi iniciado");
		else if(ultima.getTipo() == TipoHora.FIM)
			throw new ServiceException("O dia de trabalho já foi finalizado");
	}
}
