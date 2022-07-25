package com.championship.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="TIPO", nullable=false, length=512)
	private String tipo;
	

	@Column(name="DESCRICAO", nullable=false, length=512)
	private String descricao;
	
	@Column(name="DATA", nullable=false)
	private LocalDateTime data;
	
	// Definir relacionamento
	@Column(name="PARTIDA_ID", nullable=false, length=512)
	private Long partida;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Long getPartida() {
		return partida;
	}

	public void setPartida(Long partida) {
		this.partida = partida;
	}
}
