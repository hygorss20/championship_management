package com.championship.service;

import com.championship.domain.model.Players;

import java.util.List;


public interface PlayersService {

	Players salvar(Players players);
	void deletar(Players players);
	void deletarPorId(Long id);
	List<Players> listarPlayers();
	Players buscarPlayersPorId(Long id);
	
}
