package com.championship.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "Modelo do objeto time.")
public class TeamsDTO {

	@ApiModelProperty(notes = "Nome do time.", example = "Barcelona", required = true)
    private String nome;

    @ApiModelProperty(notes = "Aonde o time esta lacalizado.", example = "Espanha", required = true)
    private String localidade;

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
