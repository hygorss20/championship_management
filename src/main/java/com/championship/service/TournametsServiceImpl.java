package com.championship.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.championship.domain.model.Players;
import com.championship.domain.model.Tournaments;
import com.championship.exception.ViolacaoDeRegraEx;
import com.championship.repository.PlayersRepository;
import com.championship.repository.TournametsRepository;

import org.hibernate.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebInputException;

@Service("TournamentsService")
public class TournametsServiceImpl implements TournamentsService {

	@Autowired
	private TournametsRepository tournametsRepository;
	
	@Override
	public Tournaments salvar(Tournaments tournaments) 
	{
		if(StringHelper.isEmpty(tournaments.getDataInicioTorneio()))
			throw new ServerWebInputException("Data para o torneio não pode ser vazio");
		else if(StringHelper.isEmpty(tournaments.getCategoriaTorneio()))
			throw new ServerWebInputException("Categoria para o torneio não pode ser vazio");

		return tournametsRepository.save(tournaments);
	}


	@Override
	public void deletar(Tournaments players) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Tournaments> listarTournaments() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Tournaments buscarTournamentsPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deletarPorId(Long id) {
		// TODO Auto-generated method stub
		
	}


}
