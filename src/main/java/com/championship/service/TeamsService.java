package com.championship.service;

import com.championship.domain.model.Teams;

import java.util.List;


public interface TeamsService {

	Teams salvar(Teams teams);
	void deletar(Teams teams);
	void deletarPorId(Long id);
	List<Teams> listarTeams();
	Teams buscarTeamsPorId(Long id);
	Teams buscarTeamsPorNome(String nome);
	
}
