package com.championship.service;

import com.championship.domain.model.Matches;
import com.championship.domain.model.Tournaments;

import java.util.List;


public interface MatchesService {
	Matches salvar(Matches matches);
	void deletarPorId(Long id);
	List<Matches> listarMatches(Long tournamentId);
	Matches buscarMatchesPorId(Long id);
}
