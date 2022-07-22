package com.championship.domain.dto;


import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "Modelo do objeto de transferencia.")
public class TransfersDTO {
	
    @ApiModelProperty(notes = "Time de origem.", example = "Real Madrid")
    private TeamsDTO timeOrigem;

    @ApiModelProperty(notes = "Time destino", example = "Barcelona")
    private TeamsDTO timeDestino;
    
    @ApiModelProperty(notes = "Data da transferencia.", example = "01-01-2000")
    @JsonFormat(pattern="dd-MM-yyyy")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDate data;
    
    @ApiModelProperty(notes = "Valor da transferencia", example = "500.000.00")
    private BigDecimal valor;

	public TeamsDTO getTimeOrigem() {
		return timeOrigem;
	}

	public void setTimeOrigem(TeamsDTO timeOrigem) {
		this.timeOrigem = timeOrigem;
	}

	public TeamsDTO getTimeDestino() {
		return timeDestino;
	}

	public void setTimeDestino(TeamsDTO timeDestino) {
		this.timeDestino = timeDestino;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

    
}
