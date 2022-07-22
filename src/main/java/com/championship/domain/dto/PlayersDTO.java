package com.championship.domain.dto;


import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "Modelo do objeto jogadores.")
public class PlayersDTO {
	
    @ApiModelProperty(notes = "Nome do jogador.", example = "Messi")
    private String nome;

    @ApiModelProperty(notes = "Aonde o time esta lacalizado.", example = "Espanha")
    private String pais;
    
    @ApiModelProperty(notes = "Data de nascimento.", example = "01-01-2000")
    @JsonFormat(pattern="dd-MM-yyyy")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDate dataNascimento;

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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
    
    
}
