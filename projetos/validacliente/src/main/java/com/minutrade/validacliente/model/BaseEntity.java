/**
 *
 */
package com.minutrade.validacliente.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Classe ancestral das entidades ClienteEntity e EnderecoEntity
 * 
 * @author ericgomes
 *
 */
@MappedSuperclass
public class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	/**
	 * Controle de versao
	 */
	@JsonIgnore
	@Version
	private int version;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	/**
	 * O metodo <code>isNew()</code> ajuda a identificar se é para adicionar
	 * ou criar um objeto.
	 */
	@JsonIgnore
	public boolean isNew() {
		return getId() == null;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
