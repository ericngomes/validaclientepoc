package com.minutrade.validacliente.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TB_TELEFONE")
public class TelefoneEntity extends BaseEntity  {

	@JsonIgnore
	@ManyToOne (targetEntity = ClienteEntity.class, fetch = FetchType.LAZY)
	@NotNull
	private ClienteEntity cliente;
	
	@NotNull
	@Column(name = "NUMERO_TELEFONE", length = 13)
	private String numeroTelefone;
	
	public TelefoneEntity() {
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone=numeroTelefone;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente=cliente;
	}

	@Override
	public String toString() {
		return getNumeroTelefone();
	}


}
