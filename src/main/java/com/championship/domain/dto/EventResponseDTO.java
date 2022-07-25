package com.championship.domain.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Modelo do objeto eventos.")
public class EventResponseDTO {

    private Long id;

    @ApiModelProperty(notes = "Tipo do evento.")
    private String tipo;

    @ApiModelProperty(notes = "Uma descrição para o evento.", example = "Começa o jogo que promete pegar fogo")
    private String descricao;
    
    @ApiModelProperty(notes = "Data do evento.", example = "2022-07-24T19:02:41.183")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime data;
    
    @ApiModelProperty(notes = "Identificador da partida.")
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
