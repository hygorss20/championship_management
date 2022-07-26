package com.championship.service;

import com.championship.domain.model.Matches;
import com.championship.domain.model.Tournaments;
import com.championship.repository.MatchesRepository;
import com.championship.repository.TournametsRepository;
import org.hibernate.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebInputException;

import java.util.List;
import java.util.stream.Collectors;

@Service("MatchesService")
public class MatchesServiceImpl implements MatchesService {

	@Autowired
	private MatchesRepository matchesRepository;
	
	@Override
	public Matches salvar(Matches matches)
	{

		return matchesRepository.save(matches);
	}

	@Override
	public List<Matches> listarMatches(Long tournamentId) {
		return matchesRepository.findAll().stream()
				.filter(f -> f.getTournaments().getId() == tournamentId)
				.collect(Collectors.toList());
	}


	@Override
	public Matches buscarMatchesPorId(Long id) {
		var match = matchesRepository.findById(id);

		if (match.isPresent()) return match.get();
		else return null;
	}


	@Override
	public void deletarPorId(Long id) {
		matchesRepository.deleteById(id);
	}
}
