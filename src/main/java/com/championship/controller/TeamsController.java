package com.championship.controller;


import com.championship.domain.dto.TeamsResponseDTO;
import com.championship.domain.dto.TeamsDTO;
import com.championship.domain.mapper.TeamsMapper;
import com.championship.domain.model.Teams;
import com.championship.service.TeamsService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;
import java.util.stream.Collectors;

@SecurityRequirement(name = "finalaws")

@RestController
@RequestMapping(value = "/teams",  produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Utilizado para inserir, atualizar, deletar, listar e buscar um Time.")
public class TeamsController {

	@Autowired
	private TeamsService teamsService;
	
	@Autowired
	private final TeamsMapper teamsMapper = Mappers.getMapper(TeamsMapper.class);
	
	
	@PostMapping
	@ApiOperation(value = "Criar um novo Time.")
	public ResponseEntity<TeamsResponseDTO> inserirTime(@RequestBody TeamsDTO dto){

		Teams time = teamsMapper.toEntity(dto);
		time = teamsService.salvar(time);
		TeamsResponseDTO usuarioDTO = teamsMapper.teamsToTeamsResponseDTO(time);
		return ResponseEntity.ok(usuarioDTO);
	}

	
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualizar Time.")
	public ResponseEntity<TeamsDTO> atualizarTimePorId(@PathVariable Long id, @RequestBody TeamsDTO dto){

		Teams usuario = teamsService.buscarTeamsPorId(id);

		teamsMapper.updateEntity(dto, usuario);
		usuario = teamsService.salvar(usuario);
		TeamsDTO usuarioDTO = teamsMapper.toDTO(usuario);

		return ResponseEntity.ok(usuarioDTO);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Buscar time por ID.")
	public ResponseEntity<TeamsDTO> buscarTimePorId(@PathVariable Long id) {

		Teams usuario = teamsService.buscarTeamsPorId(id);

		TeamsDTO usuarioDTO = teamsMapper.toDTO(usuario);

		return ResponseEntity.ok(usuarioDTO);
	}

	@GetMapping
	@ApiOperation(value = "Listar todos os time.")
	public ResponseEntity<List<TeamsResponseDTO>> listar() {
		List<TeamsResponseDTO> listaTeamsResponseDTO = teamsService.listarTeams()
				.stream()
				.map(teamsMapper::teamsToTeamsResponseDTO)
				.collect(Collectors.toList());
		return ResponseEntity.ok(listaTeamsResponseDTO);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deletar time por ID.")
	public ResponseEntity<TeamsDTO> deletarUsuarioPorId(@PathVariable Long id){

		Teams teams = teamsService.buscarTeamsPorId(id);
		teamsService.deletar(teams);
		TeamsDTO teamsDTO = teamsMapper.toDTO(teams);
		return ResponseEntity.ok(teamsDTO);
	}
	
}
