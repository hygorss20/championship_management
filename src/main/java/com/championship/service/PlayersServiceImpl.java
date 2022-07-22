package com.championship.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.championship.domain.model.Players;
import com.championship.exception.ViolacaoDeRegraEx;
import com.championship.repository.PlayersRepository;
import org.hibernate.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("PlayersService")
public class PlayersServiceImpl implements PlayersService {

	@Autowired
	private PlayersRepository playersRepository;

	
	@Override
	public Players salvar(Players players) {
		
		if(StringHelper.isEmpty(players.getNome()))
			throw new ViolacaoDeRegraEx("Nome para o time não pode ser vazio");
		else if(StringHelper.isEmpty(players.getPais()))
			throw new ViolacaoDeRegraEx("Localização para o time não pode ser vazio");

		return playersRepository.save(players);
	}


	@Override
	public void deletar(Players usuario) {
		playersRepository.delete(usuario);
	}
	
	@Override
	public void deletarPorId(Long id) {
		playersRepository.deleteById(id);		
	}

	@Override
	public List<Players> listarPlayers() {
		
		List<Players> list = playersRepository.findAll();
		
		if(list.isEmpty())
			throw new EntityNotFoundException("Nenhum jogador registrado.");
		
		return list;
	}

	@Override
	public Players buscarPlayersPorId(Long id) {
		Optional<Players> usuario = playersRepository.findById(id);
		return usuario.orElseThrow(() -> new EntityNotFoundException("ID jogador não encontrado."));
	}


}
