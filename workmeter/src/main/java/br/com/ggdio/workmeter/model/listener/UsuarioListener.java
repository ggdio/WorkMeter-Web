package br.com.ggdio.workmeter.model.listener;

import org.hibernate.event.internal.DefaultSaveOrUpdateEventListener;
import org.hibernate.event.spi.SaveOrUpdateEvent;

import br.com.ggdio.workmeter.model.Usuario;

public class UsuarioListener extends DefaultSaveOrUpdateEventListener 
{
	@Override
	public void onSaveOrUpdate(SaveOrUpdateEvent event) 
	{
		if(event.getObject() instanceof Usuario)
		{
			
		}
		else
		{
			super.onSaveOrUpdate(event);
		}
	}
}
