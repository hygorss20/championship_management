package com.championship.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "Modelo do objeto Time.")
public class TeamsResponseDTO {

    private Long id;

    @ApiModelProperty(notes = "Nome do time.", example = "Barcelona")
    private String nome;

    @ApiModelProperty(notes = "Aonde o time esta lacalizado.", example = "Espanha")
    private String localidade;

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

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
    
    
}
