package com.gabrie345.msclientes.application.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gabrie345.msclientes.domain.Cliente;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClienteSaveRequestDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("cpf") 
	private String cpf;
	@JsonProperty("nome") 
	private String nome;
	@JsonProperty("idade") 
	private Integer idade;
	
	public Cliente toModel() {
		return new Cliente(cpf, nome, idade);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	
}
