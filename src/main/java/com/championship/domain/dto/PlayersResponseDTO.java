package com.championship.domain.dto;

import java.time.LocalDate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Modelo do objeto jogadores.")
public class PlayersResponseDTO {

    private Long id;

    @ApiModelProperty(notes = "Nome do jogador.", example = "Messi")
    private String nome;

    @ApiModelProperty(notes = "Aonde o time esta lacalizado.", example = "Espanha")
    private String pais;
    
    @ApiModelProperty(notes = "Data de nascimento.", example = "01/01/2000")
    private LocalDate dataNascimento;
    
    @ApiModelProperty(notes = "Time no qual o jogador esta.", example = "Barcelona")
    private TeamsDTO time;

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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public TeamsDTO getTime() {
		return time;
	}

	public void setTime(TeamsDTO idTime) {
		this.time = idTime;
	}
    
    
}
