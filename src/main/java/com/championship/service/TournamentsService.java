package com.championship.service;

import com.championship.domain.model.Tournaments;

import java.util.List;


public interface TournamentsService {

	Tournaments salvar(Tournaments tournaments);
	void deletar(Tournaments tournaments);
	void deletarPorId(Long id);
	List<Tournaments> listarTournaments();
	Tournaments buscarTournamentsPorId(Long id);
	
}
