package br.com.ggdio.workmeter.controller;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import br.com.sourcesphere.core.web.generic.controller.MasterController;
import br.com.sourcesphere.core.web.generic.controller.response.Response;
import br.com.sourcesphere.core.web.generic.service.MasterService;

/**
 * Controller for specific workmeter methods
 * @author Guilherme Dio
 * @param <T> - Param to be passed to {@link MasterController}
 */
public abstract class AbstractController<T> extends MasterController<T> {
	
	private final Logger log = Logger.getLogger(AbstractController.class);
	
	public static final int STATUS_SUCCESS = 200;
	public static final int STATUS_UNAUTHORIZED = 401;
	
	public AbstractController(MasterService<T> service) {
		super(service);
	}
	
	public Response<Object> montaResponse(String status,String message,Object informacao)
	{
		return new Response<Object>(status, message, informacao);
	}
	
	public Response<Object> montaResponseSucesso(String message,Object informacao)
	{
		return montaResponse(Response.SUCCESS, message, informacao);
	}
	
	public Response<Object> montaResponseAlerta(String message,Object informacao)
	{
		return montaResponse(Response.WARNING, message, informacao);
	}
	
	public Response<Object> montaResponseErro(String message,Object informacao)
	{
		return montaResponse(Response.ERROR, message, informacao);
	}
	
	public void preparaResponse(String identificador,Response<Object> response,Model model)
	{
		model.addAttribute(identificador, response);
	}
	
	public void preparaResponseSucesso(Response<Object> response,Model model)
	{
		preparaResponse("msgsucesso",response,model);
	}
	
	public void preparaResponseAlerta(Response<Object> response,Model model)
	{
		preparaResponse("msgalerta",response,model);
	}
	
	public void preparaResponseErro(Response<Object> response,Model model)
	{
		preparaResponse("msgerro",response,model);
	}
	
	public String serializaJson(Response<Object> response){
		XStream xstream = new XStream(new JettisonMappedXmlDriver());
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.alias("response", Response.class);
        String json = xstream.toXML(response);
        log.info("Ajax response montado em JSON: "+json);
        return json;
	}

}
