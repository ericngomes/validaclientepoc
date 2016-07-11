package com.minutrade.validacliente.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class EnderecoEntity extends BaseEntity{

	@NotNull
	@Column(name = "LOGROURO", length = 30)
	private String logrouro;
	
	@NotNull
	@Column(name = "NUMERO", length = 15)
	private String numero;
	
	@Column(name = "bairro", length = 20)
	private String bairro;
	
	@Column(name = "CEP", length = 8)
	private String cep;
}
