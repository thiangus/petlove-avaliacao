package com.petlove.avaliacao.petloveavaliacao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the agenda database table.
 * 
 */
@Entity
public class Agenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String descricao;

	@Temporal(TemporalType.DATE)
	private Date horario;

	//bi-directional many-to-one association to Animal
	@ManyToOne
	private Animal animal;

	//bi-directional many-to-one association to Proprietario
	@ManyToOne
	private Proprietario proprietario;

	//bi-directional many-to-one association to Servico
	@ManyToOne
	private Servico servico;

	public Agenda() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getHorario() {
		return this.horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public Animal getAnimal() {
		return this.animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Proprietario getProprietario() {
		return this.proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public Servico getServico() {
		return this.servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

}