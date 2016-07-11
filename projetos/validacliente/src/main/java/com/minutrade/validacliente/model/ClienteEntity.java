package com.minutrade.validacliente.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import com.minutrade.validacliente.utils.ValidaCPF;

@Entity
@Table(name = "TB_CLIENTE")
@NamedEntityGraph(name = "Cliente.detail", attributeNodes = @NamedAttributeNode("telefones") )
public class ClienteEntity extends BaseEntity {
	
	@OneToMany (targetEntity = TelefoneEntity.class, fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="cliente")
	@Valid
	private List<TelefoneEntity> telefone;
	
	@NotNull
	@Column(name = "NOME", length = 50)
	private String nome;
	
	@NotNull
	@Column(name = "CPF", length = 14)
	private String cpf;
	
	@NotNull
	@Column(name = "EMAIL", length = 50)
	private String email;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(length=1)
	private EstadoCivil estadoCivil;
	
	@Embedded
	@NotNull
	@Valid
	private EnderecoEntity endereco;
	
	
	/*
	 * Essa assertiva valida toda vez que for inserido um novo Cliente
	 * é uma regra do objeto gerenciada pelo HibernateValidator
	 */
	@AssertTrue(message = "CPF Falso")
	public boolean isValidoCPF() {
		
		return ValidaCPF.isValidCPF(this.getCpf());
	}
	
	public ClienteEntity() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome=nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf=cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email=email;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil=estadoCivil;
	}

	public List<TelefoneEntity> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<TelefoneEntity> telefone) {
		this.telefone=telefone;
	}

	@Override
	public String toString() {
		return getNome();
	}
}
