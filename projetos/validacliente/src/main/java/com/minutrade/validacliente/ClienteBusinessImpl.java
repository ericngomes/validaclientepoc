/**
 *
 */
package com.minutrade.validacliente;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.minutrade.validacliente.model.ClienteEntity;
import com.minutrade.validacliente.model.TelefoneEntity;
import com.minutrade.validacliente.repository.ClienteRepository;

/**
 *
 * @author ericgomes
 *
 */
@Component
public class ClienteBusinessImpl implements ClienteBusiness {

	private static final Logger logger = LoggerFactory.getLogger(ClienteBusinessImpl.class);

	@Autowired
	private ClienteRepository repository;

	@Autowired
	private TelefoneBusiness telefoneBusiness;

	/**
	 * Recupera um objeto do tipo ClienteEntity por id
	 *
	 * @return OrderEntity
	 */
	@Override
	public ClienteEntity findById(Long id) {
		logger.info("Rodando o metodo findById");
		return repository.findOne(id);
	}

	/**
	 * Recupera uma lista de cliente
	 *
	 * @return listaOrder
	 */
	@Override
	public List<ClienteEntity> findAll() {
		logger.info("Rodando o metodo findAll");
		return repository.findAll();
	}

	/**
	 * Inclui <code>ClienteEntity</code>
	 */
	@Override
	public Long save(ClienteEntity cliente) {

		//validar cpf incluida como assertiva no Objeto "ClienteEntity"
		
		ClienteEntity save = repository.save(cliente);

		return save.getId();
	}


	/**
	 * Realiza update of <code>ClienteEntity</code>
	 * 
	 */
	@Override
	public Long update(ClienteEntity cliente) {

		if (cliente.getTelefone() != null && !cliente.getTelefone().isEmpty()) {

			for (TelefoneEntity telefone : cliente.getTelefone()) {
				telefoneBusiness.update(telefone);
			}
		}

		repository.save(cliente);

		return cliente.getId();
	}


}
