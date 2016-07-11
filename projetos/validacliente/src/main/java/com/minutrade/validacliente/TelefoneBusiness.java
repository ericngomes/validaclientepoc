/**
 *
 */
package com.minutrade.validacliente;

import java.util.List;

import org.springframework.stereotype.Service;

import com.minutrade.validacliente.model.TelefoneEntity;

/**
 * @author ericgomes
 *
 */
@Service
public interface TelefoneBusiness {

	/**
	 * Busca telefone por id <code>TelefoneEntity</code>
	 *
	 * @param id
	 * @return TelefoneEntity
	 */
	TelefoneEntity findById(Long id);

	/**
	 * Alterar teefone
	 * 
	 * @param telefone
	 */
	void update(TelefoneEntity telefone);

	/**
	 * @return Lista de TelefoneEntity
	 */
	List<TelefoneEntity> findAll();

}
