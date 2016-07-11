/**
 *
 */
package com.minutrade.validacliente.rest;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.minutrade.validacliente.model.ClienteEntity;
import com.minutrade.validacliente.service.ValidaClienteService;

/**
 *
 * @author ericgomes
 *
 */
@Component
@Path("/cliente")
public class ClienteResource {

	@Autowired
	private ValidaClienteService service;

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	public Response createOrder(ClienteEntity cliente) throws Exception {
		Long newClienteId = service.createCliente(cliente);
		return Response.status(Response.Status.CREATED).entity("Novo Cliente criado!")
				.header("Location", "http://localhost:8080/rest/cliente/" + String.valueOf(newClienteId)).build();
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Path("{id}")
	@Produces({ MediaType.TEXT_HTML })
	public Response putClienteById(@PathParam("id") Long id, @Valid ClienteEntity cliente) throws Exception {

		ClienteEntity clienteById = service.findClienteById(id);

		if (clienteById == null) {

			Long newClienteId = service.createCliente(cliente);
			return Response.status(Response.Status.CREATED)
					.entity("Um novo cliente foi criado")
					.header("Localizacao", "http://localhost:8080/rest/cliente/" + String.valueOf(newClienteId)).build();
		} else {
			cliente.setId(clienteById.getId());
			cliente.setVersion(clienteById.getVersion());
			Long updateClienteId = service.updateCliente(cliente);
			return Response.status(Response.Status.OK)
					.entity("O Cliente foi alterado")
					.header("Localizacao", "http://localhost:8080/rest/cliente/" + String.valueOf(updateClienteId)).build();
		}
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("{id}")
	public ClienteEntity getClienteById(@PathParam("id") Long id) throws Exception {

		ClienteEntity clienteEntity = service.findClienteById(id);

		return clienteEntity;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<ClienteEntity> getOrders() throws Exception {

		List<ClienteEntity> listaOrder = service.findAllClientes();

		return listaOrder;
	}

	
}
