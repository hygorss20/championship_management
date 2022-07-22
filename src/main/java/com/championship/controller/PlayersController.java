package com.championship.controller;


import java.util.List;
import java.util.stream.Collectors;

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

import com.championship.domain.dto.PlayersDTO;
import com.championship.domain.dto.PlayersResponseDTO;
import com.championship.domain.mapper.PlayersMapper;
import com.championship.domain.model.Players;
import com.championship.domain.model.Teams;
import com.championship.service.PlayersService;
import com.championship.service.TeamsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


@SecurityRequirement(name = "finalaws")

@RestController
@RequestMapping(value = "/players",  produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Utilizado para inserir, atualizar, deletar, listar e buscar um Jogador.")
public class PlayersController {

	@Autowired
	private PlayersService playersService;
	
	@Autowired
	private TeamsService teamsService;
	
	@Autowired
	private final PlayersMapper playersMapper = Mappers.getMapper(PlayersMapper.class);
	
	
	@PostMapping("/teams/{id}")
	@ApiOperation(value = "Criar um novo jogador.")
	public ResponseEntity<PlayersResponseDTO> inserirJogador(@PathVariable Long id, @RequestBody PlayersDTO dto) {

		Players players = playersMapper.toEntity(dto);

		if (id != null) {
			Teams time = teamsService.buscarTeamsPorId(id);
			players.setTime(time);
		}

		players = playersService.salvar(players);
		PlayersResponseDTO playersResponseDTO = playersMapper.playersToPlayersResponseDTO(players);
		return ResponseEntity.ok(playersResponseDTO);
	}

	
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualizar Jogador.")
	public ResponseEntity<PlayersDTO> atualizarJogadorPorId(@PathVariable Long id, @RequestBody PlayersDTO dto){

		Players players = playersService.buscarPlayersPorId(id);

		playersMapper.updateEntity(dto, players);
		players = playersService.salvar(players);
		PlayersDTO playersDTO = playersMapper.toDTO(players);

		return ResponseEntity.ok(playersDTO);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Buscar time por ID.")
	public ResponseEntity<PlayersDTO> buscarJogadorPorId(@PathVariable Long id) {

		Players players = playersService.buscarPlayersPorId(id);

		PlayersDTO playersDTO = playersMapper.toDTO(players);

		return ResponseEntity.ok(playersDTO);
	}

	@GetMapping
	@ApiOperation(value = "Listar todos os time.")
	public ResponseEntity<List<PlayersResponseDTO>> listar() {
		List<PlayersResponseDTO> listaPlayersResponseDTO = playersService.listarPlayers()
				.stream()
				.map(playersMapper::playersToPlayersResponseDTO)
				.collect(Collectors.toList());
		return ResponseEntity.ok(listaPlayersResponseDTO);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deletar jogador por ID.")
	public ResponseEntity<PlayersDTO> deletarJogadorPorId(@PathVariable Long id){

		Players players = playersService.buscarPlayersPorId(id);
		playersService.deletar(players);
		PlayersDTO playersDTO = playersMapper.toDTO(players);
		return ResponseEntity.ok(playersDTO);
	}
	
}
