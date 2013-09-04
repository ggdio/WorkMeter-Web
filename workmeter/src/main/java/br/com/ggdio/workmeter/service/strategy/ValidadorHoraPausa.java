package br.com.ggdio.workmeter.service.strategy;

import br.com.ggdio.workmeter.model.Hora;
import br.com.ggdio.workmeter.model.TipoHora;
import br.com.sourcesphere.core.web.generic.service.exception.ServiceException;

public class ValidadorHoraPausa implements ValidadorHora {

	@Override
	public void validaHora(Hora hora, Hora ultima) {
		if(ultima.getTipo() == TipoHora.FIM)
			throw new ServiceException("O dia de trabalho ainda não foi iniciado");
		else if(ultima.getTipo() != TipoHora.RETORNO)
			throw new ServiceException("O trabalho ainda não foi retomado");
	}

}
