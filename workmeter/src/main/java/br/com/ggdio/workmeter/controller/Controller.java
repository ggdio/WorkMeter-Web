package br.com.ggdio.workmeter.controller;

import br.com.ggdio.workmeter.view.PathHandler;
import br.com.ggdio.workmeter.view.ViewHandler;

public abstract class Controller implements ViewHandler,PathHandler
{
	public abstract String getGenericAttributeIdentifier();
}
