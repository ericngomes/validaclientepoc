/**
 *
 */
package com.minutrade.validacliente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.repository.CrudRepository;

import com.minutrade.validacliente.model.ClienteEntity;

/**
 * @author ericgomes
 * @since 11/07/2016
 */
public interface ClienteRepository extends CrudRepository<ClienteEntity, Long> {


	/**
	 * Recupera uma lista de cliente
	 * 
	 * @return
	 */
	@Override
	@EntityGraph(value = "Cliente.detail", type = EntityGraphType.FETCH)
	List<ClienteEntity> findAll();
	
	@EntityGraph(value = "Cliente.detail", type = EntityGraphType.FETCH)
	ClienteEntity findByIdClienteById(Long id);

}
