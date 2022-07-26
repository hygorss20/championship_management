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
public class Tournaments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NOME", nullable=false, length=512)
	private String nome;
	
	@Column(name="ENTIDADE_RESPONSAVEL", nullable=false, length=512)
	private String entidadeResponsavel;
	
	@Column(name="CATEGORIA_TORNEIO", nullable=false, length=512)
	private String categoriaTorneio;
	
	@Column(name="DATA_INICIO_TORNEIO", nullable=false, length=512)
	private String dataInicioTorneio;
	
	@Column(name="DATA_FIM_TORNEIO", nullable=false, length=512)
	private String dataFimTorneio;	
	
	@ManyToOne
	@JoinColumn(name="ID_TEAMS")
	private Teams time;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEntidadeResponsavel() {
		return entidadeResponsavel;
	}

	public void setEntidadeResponsavel(String entidadeResponsavel) {
		this.entidadeResponsavel = entidadeResponsavel;
	}

	public String getCategoriaTorneio() {
		return categoriaTorneio;
	}

	public void setCategoriaTorneio(String categoriaTorneio) {
		this.categoriaTorneio = categoriaTorneio;
	}

	
	public String getDataInicioTorneio() {
		return dataInicioTorneio;
	}

	public void setDataInicioTorneio(String dataInicioTorneio) {
		this.dataInicioTorneio = dataInicioTorneio;
	}

	public String getDataFimTorneio() {
		return dataFimTorneio;
	}

	public void setDataFimTorneio(String dataFimTorneio) {
		this.dataFimTorneio = dataFimTorneio;
	}

	public Teams getTime() {
		return time;
	}

	public void setTime(Teams time) {
		this.time = time;
	}	
	
}
