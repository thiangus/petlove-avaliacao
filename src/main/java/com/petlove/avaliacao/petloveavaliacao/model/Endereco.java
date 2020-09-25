package com.petlove.avaliacao.petloveavaliacao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the endereco database table.
 * 
 */
@Entity
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String cep;

	private String cidade;

	private String complemento;

	private String logradouro;

	private String uf;

	//bi-directional many-to-one association to Proprietario
	@OneToMany(mappedBy="endereco")
	private List<Proprietario> proprietarios;

	public Endereco() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Proprietario> getProprietarios() {
		return this.proprietarios;
	}

	public void setProprietarios(List<Proprietario> proprietarios) {
		this.proprietarios = proprietarios;
	}

	public Proprietario addProprietario(Proprietario proprietario) {
		getProprietarios().add(proprietario);
		proprietario.setEndereco(this);

		return proprietario;
	}

	public Proprietario removeProprietario(Proprietario proprietario) {
		getProprietarios().remove(proprietario);
		proprietario.setEndereco(null);

		return proprietario;
	}

}