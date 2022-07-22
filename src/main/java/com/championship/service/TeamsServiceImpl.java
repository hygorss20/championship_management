package com.championship.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.championship.domain.model.Teams;
import com.championship.exception.ViolacaoDeRegraEx;
import com.championship.repository.TeamsRepository;
import org.hibernate.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("TeamsService")
public class TeamsServiceImpl implements TeamsService {

	@Autowired
	private TeamsRepository teamsRepository;

	
	@Override
	public Teams salvar(Teams teams) {
		
		if(StringHelper.isEmpty(teams.getNome()))
			throw new ViolacaoDeRegraEx("Nome para o time não pode ser vazio");
		else if(StringHelper.isEmpty(teams.getLocalidade()))
			throw new ViolacaoDeRegraEx("Localização para o time não pode ser vazio");

		return teamsRepository.save(teams);
	}


	@Override
	public void deletar(Teams usuario) {
		teamsRepository.delete(usuario);
	}
	
	@Override
	public void deletarPorId(Long id) {
		teamsRepository.deleteById(id);		
	}

	@Override
	public List<Teams> listarTeams() {
		
		List<Teams> list = teamsRepository.findAll();
		
		if(list.isEmpty())
			throw new EntityNotFoundException("Nenhum time registrado.");
		
		return list;
	}

	@Override
	public Teams buscarTeamsPorId(Long id) {
		Optional<Teams> usuario = teamsRepository.findById(id);
		return usuario.orElseThrow(() -> new EntityNotFoundException("ID time não encontrado."));
	}
	
	@Override
	public Teams buscarTeamsPorNome(String nome) {
		Optional<Teams> usuario = teamsRepository.findByNome(nome);
		return usuario.orElseThrow(() -> new EntityNotFoundException(
				String.format("Time não encontrado atraves do nome %s", nome)));
	}

}
