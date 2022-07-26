package com.championship.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Players {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="NOME", nullable=false, length=512)
	private String nome;
	

	@Column(name="PAIS", nullable=false, length=512)
	private String pais;
	
	@Column(name="DATA_NASCIMENTO", nullable=false, length=512)
	private String dataNascimento;
	
	@ManyToOne
	@JoinColumn(name="ID_TEAMS")
	private Teams time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Teams getTime() {
		return time;
	}

	public void setTime(Teams time) {
		this.time = time;
	}
	
	
}
