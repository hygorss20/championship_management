package com.championship.domain.dto;

import java.time.LocalDate;
import java.util.List;

import com.championship.domain.model.Teams;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@ApiModel(description = "Modelo do objeto Torneio.")
public class TournamentsDTO 
{
	@ApiModelProperty(notes = "Nome do Torneio.", example = "Campeonato Brasileiro")
    private String nome;

    @ApiModelProperty(notes = "Entidade resposnavel pelo Tornerio", example = "CBF")
    private String entidadeResponsavel;
    
    @ApiModelProperty(notes = "Categoria do Torneio", example = "Adulto para atletas de 20 anos em diante. Sub-20 para atletas de 18, 19 e 20 anos.")
    private String categoriaTorneio;
        
    @ApiModelProperty(notes = "Data Inicio Torneio.", example = "01-01-2000")
    @JsonFormat(pattern="dd-MM-yyyy")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDate dataInicioTorneio;
    
    @ApiModelProperty(notes = "Data Fim Torneio.", example = "01-01-2000")
    @JsonFormat(pattern="dd-MM-yyyy")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDate dataFimTorneio;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public LocalDate getDataInicioTorneio() {
		return dataInicioTorneio;
	}

	public void setDataInicioTorneio(LocalDate dataInicioTorneio) {
		this.dataInicioTorneio = dataInicioTorneio;
	}

	public LocalDate getDataFimTorneio() {
		return dataFimTorneio;
	}

	public void setDataFimTorneio(LocalDate dataFimTorneio) {
		this.dataFimTorneio = dataFimTorneio;
	}
}
