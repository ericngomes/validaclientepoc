/**
 *
 */
package com.minutrade.validacliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.minutrade.validacliente.model.TelefoneEntity;
import com.minutrade.validacliente.repository.TelefoneRepository;

/**
 * This class has responsibility for dealing with business rules of ProductEntity
 *
 * @author ericgomes
 *
 */
@Component
public class TelefoneBusinessImpl implements TelefoneBusiness {

	@Autowired
	private TelefoneRepository repository;

	/**
	 * Recupera um objeto do tipo <code>TelefoneEntity</code> por id
	 *
	 * @return <code>ProductEntity</code>
	 */
	@Override
	public TelefoneEntity findById(Long id) {
		return repository.findOne(id);
	}

	/**
	 * Altere o <code>TelefoneEntity</code>
	 */
	@Override
	public void update(TelefoneEntity product) {
		repository.save(product);
	}

	/**
	 * Recupera a lista de TelefoneEntity
	 */
	@Override
	public List<TelefoneEntity> findAll() {
		return (List<TelefoneEntity>) repository.findAll();
	}

}
