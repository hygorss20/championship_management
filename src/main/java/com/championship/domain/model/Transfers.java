package com.championship.domain.model;

import java.math.BigDecimal;

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
public class Transfers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name="TIME_ORIGEM")
	private Teams timeOrigem;
	
	@ManyToOne
	@JoinColumn(name="TIME_DESTINO")
	private Teams timeDestino;
	
	@Column(name="DATA", nullable=false, length=512)
	private String data;
	
	@Column(name="VALOR", nullable=false, length=512)
	private BigDecimal valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Teams getTimeOrigem() {
		return timeOrigem;
	}

	public void setTimeOrigem(Teams timeOrigem) {
		this.timeOrigem = timeOrigem;
	}

	public Teams getTimeDestino() {
		return timeDestino;
	}

	public void setTimeDestino(Teams timeDestino) {
		this.timeDestino = timeDestino;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
	
}
