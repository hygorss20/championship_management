package com.championship.controller;

import java.util.List;

import com.championship.domain.dto.MatchesDTO;
import com.championship.domain.mapper.MatchesMapper;
import com.championship.domain.mapper.TeamsMapper;
import com.championship.domain.model.Matches;
import com.championship.service.MatchesService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.championship.domain.dto.TournamentsDTO;
import com.championship.domain.mapper.TournamentsMapper;
import com.championship.domain.model.Tournaments;
import com.championship.service.TournamentsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.server.ServerWebInputException;

@RestController
@RequestMapping(value = "/tournaments",  produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Utilizado para inserir, atualizar, deletar, listar e buscar um Torneio.")
public class TournamentsController 
{
	
	@Autowired
	private TournamentsService tournamentsService;

	@Autowired
	private MatchesService matchesService;
	
	@Autowired
	private final TournamentsMapper tournamentsMapper = Mappers.getMapper(TournamentsMapper.class);

	@Autowired
	private final MatchesMapper matchesMapper = Mappers.getMapper(MatchesMapper.class);

	@Autowired
	private final TeamsMapper teamsMapper = Mappers.getMapper(TeamsMapper.class);
	
	
	@PostMapping
	@ApiOperation(value = "Criar um novo Torneio.")
	public ResponseEntity<TournamentsDTO> inserirTorneio(@RequestBody TournamentsDTO dto){
		Tournaments tournaments =  tournamentsMapper.toEntity(dto);
		tournaments = tournamentsService.salvar(tournaments);
		TournamentsDTO tournamentsDTO = tournamentsMapper.tournamentsToTournamentsResponseDTO(tournaments);
				
		return ResponseEntity.ok(tournamentsDTO);
	}

	@PostMapping("/{id}/match")
	@ApiOperation(value = "Cadastra partida em um Torneio.")
	public ResponseEntity<MatchesDTO> inserirPartidaEmTorneio(@PathVariable Long id, @RequestBody MatchesDTO dto){
		if (dto.getTime().size() != 2)
			throw new ServerWebInputException("É necessário 2 times para uma partida");

		Matches matches =  matchesMapper.toEntity(dto);
		matches = matchesService.salvar(matches);
		var matchesDto = matchesMapper.matchesToMatchesDTO(matches);

		return ResponseEntity.ok(matchesDto);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualizar Torneio.")
	public ResponseEntity<TournamentsDTO> atualizarTorneioPorId(@PathVariable Long id, @RequestBody TournamentsDTO dto){
		Tournaments tournaments =  tournamentsMapper.toEntity(dto);
		tournaments.setId(id);
		tournamentsService.salvar(tournaments);
		return ResponseEntity.ok(dto);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Buscar torneio por ID.")
	public ResponseEntity<Tournaments> buscarTorneioPorId(@PathVariable Long id) {
		return ResponseEntity.ok(tournamentsService.buscarTournamentsPorId(id));
	}

	@GetMapping
	@ApiOperation(value = "Listar todos os torneios.")
	public ResponseEntity<List<Tournaments>> listar() {
		List<Tournaments> listaTournamentsDTO = tournamentsService.listarTournaments();

		return ResponseEntity.ok(listaTournamentsDTO);
	}

	@GetMapping("/{id}/match")
	@ApiOperation(value = "Listar todos as partidas do torneio.")
	public ResponseEntity<List<Matches>> listarMatches(@PathVariable Long id) {
		var matches = matchesService.listarMatches(id);
		return ResponseEntity.ok(matches);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deletar torneio por ID.")
	public ResponseEntity deletarTorneiorPorId(@PathVariable Long id){
		tournamentsService.deletarPorId(id);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/match/{id}")
	@ApiOperation(value = "Deletar partida por ID.")
	public ResponseEntity deletarPartidaPorId(@PathVariable Long id){
		matchesService.deletarPorId(id);
		return ResponseEntity.ok().build();
	}
}
