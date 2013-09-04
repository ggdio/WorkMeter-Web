package br.com.ggdio.workmeter.model;

import br.com.ggdio.workmeter.service.strategy.ValidadorHora;
import br.com.ggdio.workmeter.service.strategy.ValidadorHoraFim;
import br.com.ggdio.workmeter.service.strategy.ValidadorHoraInicio;
import br.com.ggdio.workmeter.service.strategy.ValidadorHoraPausa;
import br.com.ggdio.workmeter.service.strategy.ValidadorHoraRetorno;

public enum TipoHora 
{
	INICIO(new ValidadorHoraInicio()),
	PAUSA(new ValidadorHoraPausa()),
	RETORNO(new ValidadorHoraRetorno()),
	FIM(new ValidadorHoraFim());
	
	private final ValidadorHora validador;
	
	TipoHora(ValidadorHora validador){
		this.validador = validador;
	}
	
	public ValidadorHora getValidadorHora(){
		return validador;
	}
}
