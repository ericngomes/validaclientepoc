/**
 *
 */
package com.minutrade.validacliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minutrade.validacliente.ClienteBusiness;
import com.minutrade.validacliente.TelefoneBusiness;
import com.minutrade.validacliente.model.ClienteEntity;
import com.minutrade.validacliente.model.TelefoneEntity;

/**
 * Classe de servico responsavel por manter todos os Business e repositorys injetados para a camada de controle de acesso
 * e persistencia
 *
 * @author ericgomes
 * @since 11/02/2016 09:06
 */
@Service
public class ValidaClienteService {

	@Autowired
	private TelefoneBusiness telefoneBusiness;

	@Autowired
	private ClienteBusiness clienteBusiness;

	/**
	 * Recupera um object <code>ClienteEntity</code> pelo ID
	 *
	 * @param id
	 * @return ClienteEntity
	 */
	public ClienteEntity findClienteById(Long id) {
		return clienteBusiness.findById(id);
	}

	/**
	 * Recupera a lista de <code>ClienteEntity</code>
	 *
	 * @return
	 */
	public List<ClienteEntity> findAllClientes() {
		return clienteBusiness.findAll();
	}

	/**
	 * @param criaCliente
	 * @return
	 */
	public Long createCliente(ClienteEntity cliente) {
		return clienteBusiness.save(cliente);
	}

	/**
	 * @param cliente
	 * @return
	 */
	public Long updateCliente(ClienteEntity cliente) {
		return clienteBusiness.save(cliente);
	}

	/**
	 * Returna lista de telefones
	 * @return
	 */
	public List<TelefoneEntity> listTelefone() {
		return telefoneBusiness.findAll();
	}

	/**
	 * Retorna um <code>TelefoneEntity</code> por ID
	 * @param id
	 * @return TelefoneEntity
	 */
	public TelefoneEntity findTelefoneById(Long id) {
		return telefoneBusiness.findById(id);
	}

}
