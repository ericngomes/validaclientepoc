/**
 *
 */
package com.minutrade.validacliente;

import java.util.List;

import org.springframework.stereotype.Service;

import com.minutrade.validacliente.model.ClienteEntity;

/**
 * Responsavel pela interface que faz a ponte entre camadas de negocio e perrsistencia	
 *
 * @author ericgomes
 * @since 11/07/2016 11:21
 */
@Service
public interface ClienteBusiness {

	/**
	 * Recupera um cliente
	 *
	 * @return ClienteEntitu
	 */
	ClienteEntity findById(Long id);

	/**
	 * Resupera uma lista de <code>ClienteEntity</code>
	 *
	 * @return
	 */
	List<ClienteEntity> findAll();

	/**
	 * Salva um cliente
	 * @param order
	 * @return
	 */
	Long save(ClienteEntity cliente);

	/**
	 * Altera Cliente
	 * @param cliente
	 * @return
	 */
	Long update(ClienteEntity cliente);
}
