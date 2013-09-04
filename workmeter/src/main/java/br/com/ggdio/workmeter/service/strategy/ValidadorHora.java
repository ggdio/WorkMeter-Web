package br.com.ggdio.workmeter.service.strategy;

import br.com.ggdio.workmeter.model.Hora;

/**
 * Strategy interface for hour validation
 * @author Guilherme Dio
 * @since 04/09/2013
 */
public interface ValidadorHora {
	public void validaHora(Hora hora,Hora ultimaDeclarada);
}
