package br.com.ggdio.workmeter.version;

import java.util.Properties;

import org.apache.log4j.Logger;

import br.com.ggdio.workmeter.interceptor.GeralInterceptor;

public class Version {
	
	private static final Logger log = Logger.getLogger(GeralInterceptor.class);
	private static String versao = "";
	
	/**
	 * Loads the system version
	 */
	static{
		Properties props = new Properties();
		try {
			props.load(GeralInterceptor.class.getClassLoader().getResourceAsStream("version.properties"));
		} catch (Exception e) {
			log.warn("Could not load the system current version: "+e.getMessage());
			props.setProperty("version", "undefined");
		}
		finally{
			versao = props.getProperty("version");
			props.clear();
			props = null;
		}
	}
	
	public static String getSystemVersion(){
		return Version.versao;
	}
}
