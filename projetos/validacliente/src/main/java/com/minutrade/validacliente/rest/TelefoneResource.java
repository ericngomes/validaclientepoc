/**
 *
 */
package com.minutrade.validacliente.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.minutrade.validacliente.model.TelefoneEntity;
import com.minutrade.validacliente.service.ValidaClienteService;

/**
 * @author ericgomes
 * 
 */
@Component
@Path("/telefone")
public class TelefoneResource {

	@Autowired
	private ValidaClienteService service;

	/**
	 * Offers the service of <li>list product catalog</li>
	 * 
	 * @return
	 * @throws Exception
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_HTML })
	public Response getTelefones() throws Exception {

		List<TelefoneEntity> telefones = service.listTelefone();

		if (CollectionUtils.isEmpty(telefones)) {
			throw new NotFoundException(
					"Por favor, voce precisa seguir os passos para inserir telefone");
		}

		StringBuilder sb = new StringBuilder();
		if (!CollectionUtils.isEmpty(telefones)) {

			for (TelefoneEntity product : telefones) {

				sb.append("<li>" + "Numero Telefone: "
						+ product.getNumeroTelefone() + "</li>");

			}
		}

		return Response
				.status(Response.Status.OK)
				.entity("<h1>Telefones</h1>" + "<lu>" + sb.toString() + "</lu>")
				.header("Location",
						"http://localhost:8080/rest/telefone/"
								+ String.valueOf(1)).build();

	}

	@GET
	@Produces({ MediaType.TEXT_HTML })
	@Path("{id}")
	public TelefoneEntity getOrderById(@PathParam("id") Long id)
			throws Exception {

		TelefoneEntity productById = service.findTelefoneById(id);

		return productById;
	}

}
