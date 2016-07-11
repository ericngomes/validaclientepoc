package com.minutrade.validacliente.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * Registra os componentss de usabilidade da aplicacao JAX-RS
 * 
 * @author ericgomes
 * @since 11/07/2016
 */
@ApplicationPath("/rest")
public class RESTConfig extends ResourceConfig {

	public RESTConfig() {
		register(ClienteResource.class);
		register(TelefoneResource.class);
	}
}
