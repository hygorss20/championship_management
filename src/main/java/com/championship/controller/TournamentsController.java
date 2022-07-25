package com.championship.controller;

import java.util.ArrayList;
import java.util.List;

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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/tournaments",  produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Utilizado para inserir, atualizar, deletar, listar e buscar um Torneio.")
public class TournamentsController 
{
	
	@PostMapping
	@ApiOperation(value = "Criar um novo Torneio.")
	public ResponseEntity<TournamentsDTO> inserirTime(@RequestBody TournamentsDTO dto){

		//Teams time = teamsMapper.toEntity(dto);
		//time = teamsService.salvar(time);
		//TeamsResponseDTO usuarioDTO = teamsMapper.teamsToTeamsResponseDTO(time);
		//return ResponseEntity.ok(usuarioDTO);
		
		return ResponseEntity.ok(dto);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualizar Torneio.")
	public ResponseEntity<TournamentsDTO> atualizarJogadorPorId(@PathVariable Long id, @RequestBody TournamentsDTO dto){

		/**Players players = playersService.buscarPlayersPorId(id);

		playersMapper.updateEntity(dto, players);
		players = playersService.salvar(players);
		PlayersDTO playersDTO = playersMapper.toDTO(players);*/

		return ResponseEntity.ok(dto);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Buscar torneio por ID.")
	public ResponseEntity<TournamentsDTO> buscarJogadorPorId(@PathVariable Long id) {

		//Players players = playersService.buscarPlayersPorId(id);

		//PlayersDTO playersDTO = playersMapper.toDTO(players);

		//return ResponseEntity.ok(playersDTO);
		
		return ResponseEntity.ok(new TournamentsDTO());
	}

	@GetMapping
	@ApiOperation(value = "Listar todos os torneios.")
	public ResponseEntity<List<TournamentsDTO>> listar() {
		/**List<PlayersResponseDTO> listaPlayersResponseDTO = playersService.listarPlayers()
				.stream()
				.map(playersMapper::playersToPlayersResponseDTO)
				.collect(Collectors.toList());
		return ResponseEntity.ok(listaPlayersResponseDTO);*/
		
		ArrayList list = new ArrayList<TournamentsDTO>();
		
		return ResponseEntity.ok(list);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deletar torneio por ID.")
	public ResponseEntity<TournamentsDTO> deletarJogadorPorId(@PathVariable Long id){

		/**Players players = playersService.buscarPlayersPorId(id);
		playersService.deletar(players);
		PlayersDTO playersDTO = playersMapper.toDTO(players);
		return ResponseEntity.ok(playersDTO);*/
		
		return ResponseEntity.ok(new TournamentsDTO());			
	}


}
