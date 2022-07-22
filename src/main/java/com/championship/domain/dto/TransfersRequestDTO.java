package com.championship.domain.dto;


import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "Modelo do objeto de transferencia.")
public class TransfersRequestDTO {
	
    @ApiModelProperty(notes = "Time de origem.", example = "Real Madrid")
    private String timeOrigem;

    @ApiModelProperty(notes = "Time destino", example = "Barcelona")
    private String timeDestino;
    
    @ApiModelProperty(notes = "Data da transferencia.", example = "01-01-2000")
    @JsonFormat(pattern="dd-MM-yyyy")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDate data;
    
    @ApiModelProperty(notes = "Valor da transferencia", example = "500.000.00")
    private BigDecimal valor;

	public String getTimeOrigem() {
		return timeOrigem;
	}

	public void setTimeOrigem(String timeOrigem) {
		this.timeOrigem = timeOrigem;
	}

	public String getTimeDestino() {
		return timeDestino;
	}

	public void setTimeDestino(String timeDestino) {
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
