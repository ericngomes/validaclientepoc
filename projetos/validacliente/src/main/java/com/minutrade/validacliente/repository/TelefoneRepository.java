/**
 *
 */
package com.minutrade.validacliente.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.minutrade.validacliente.model.TelefoneEntity;

/**
 * Responsavel pelo mapeamento de interface dos metodos sde aacesso do banco das informacoes de TelefoneEntity
 *
 * @author ericgomes
 */
@Repository
public interface TelefoneRepository extends CrudRepository<TelefoneEntity, Long> {

}
