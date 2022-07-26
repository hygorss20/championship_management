package com.championship.controller;


import java.util.List;
import java.util.stream.Collectors;

import com.championship.enums.EventType;
import com.championship.exception.ViolacaoDeRegraEx;
import org.hibernate.internal.util.StringHelper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.championship.domain.dto.EventDTO;
import com.championship.domain.dto.EventResponseDTO;
import com.championship.domain.mapper.EventMapper;
import com.championship.domain.model.Event;
import com.championship.service.EventService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.server.ServerWebInputException;


//@SecurityRequirement(name = "finalaws")

@RestController
@RequestMapping(value = "/torneios/{torneioId}/partidas/{partidaId}",  produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Gera eventos da partida.")
public class EventsController {

	@Autowired
	private EventService eventService;
	
	@Autowired
	private final EventMapper eventMapper  = Mappers.getMapper(EventMapper.class);
	
	@PostMapping("/eventos/inicio")
	@ApiOperation(value = "Criar um novo evento para Inicio de partida.")
	public ResponseEntity<EventResponseDTO> inserirEventoInicio(@PathVariable Long torneioId, @PathVariable Long partidaId, @RequestBody EventDTO dto) {

		EventResponseDTO eventResponseDTO = processEvent(torneioId, partidaId, dto, EventType.INICIO);
		return ResponseEntity.status(HttpStatus.CREATED).body(eventResponseDTO);
	}

	@PostMapping("/eventos/gol")
	@ApiOperation(value = "Criar um novo evento para gol.")
	public ResponseEntity<EventResponseDTO> inserirEventoGol(@PathVariable Long torneioId, @PathVariable Long partidaId, @RequestBody EventDTO dto) {

		EventResponseDTO eventResponseDTO = processEvent(torneioId, partidaId, dto, EventType.GOL);
		return ResponseEntity.status(HttpStatus.CREATED).body(eventResponseDTO);
	}

	@PostMapping("/eventos/intervalo")
	@ApiOperation(value = "Criar um novo evento para intervalo de partida.")
	public ResponseEntity<EventResponseDTO> inserirEventoIntervalo(@PathVariable Long torneioId, @PathVariable Long partidaId, @RequestBody EventDTO dto) {

		EventResponseDTO eventResponseDTO = processEvent(torneioId, partidaId, dto, EventType.INTERVALO);
		return ResponseEntity.status(HttpStatus.CREATED).body(eventResponseDTO);
	}

	@PostMapping("/eventos/acrescimo")
	@ApiOperation(value = "Criar um novo evento para acrescimo.")
	public ResponseEntity<EventResponseDTO> inserirEventoAcrescimo(@PathVariable Long torneioId, @PathVariable Long partidaId, @RequestBody EventDTO dto) {

		EventResponseDTO eventResponseDTO = processEvent(torneioId, partidaId, dto, EventType.ACRESCIMO);
		return ResponseEntity.status(HttpStatus.CREATED).body(eventResponseDTO);
	}

	@PostMapping("/eventos/substituicao")
	@ApiOperation(value = "Criar um novo evento para substituicao.")
	public ResponseEntity<EventResponseDTO> inserirEventoSubstituicao(@PathVariable Long torneioId, @PathVariable Long partidaId, @RequestBody EventDTO dto) {

		EventResponseDTO eventResponseDTO = processEvent(torneioId, partidaId, dto, EventType.SUBSTITUICAO);
		return ResponseEntity.status(HttpStatus.CREATED).body(eventResponseDTO);
	}

	@PostMapping("/eventos/advertencia")
	@ApiOperation(value = "Criar um novo evento para advertencia.")
	public ResponseEntity<EventResponseDTO> inserirEventoAdvertencia(@PathVariable Long torneioId, @PathVariable Long partidaId, @RequestBody EventDTO dto) {

		EventResponseDTO eventResponseDTO = processEvent(torneioId, partidaId, dto, EventType.ADVERTENCIA);
		return ResponseEntity.status(HttpStatus.CREATED).body(eventResponseDTO);
	}

	@PostMapping("/eventos/fim")
	@ApiOperation(value = "Criar um novo evento para fim de partida.")
	public ResponseEntity<EventResponseDTO> inserirEventoFim(@PathVariable Long torneioId, @PathVariable Long partidaId, @RequestBody EventDTO dto) {

		EventResponseDTO eventResponseDTO = processEvent(torneioId, partidaId, dto, EventType.FIM);
		return ResponseEntity.status(HttpStatus.CREATED).body(eventResponseDTO);
	}

	@GetMapping("/eventos")
	@ApiOperation(value = "Listar todos eventos de uma partida.")
	public ResponseEntity<List<EventResponseDTO>> listar() {
		List<EventResponseDTO> eventList = eventService.listarEvents()
				.stream()
				.map(eventMapper::eventToEventResponseDTO)
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(eventList);
	}

	private Boolean torneioExiste(Long torneioId) {
		return true;
	}

	private Boolean partidaExiste(Long partidaId) {
		return true;
	}

	private EventResponseDTO processEvent(Long torneioId, Long partidaId, EventDTO dto, EventType eventType) {
		if(!torneioExiste(torneioId))
			throw new ServerWebInputException("Torneio tem que existir");

		if(!torneioExiste(partidaId))
			throw new ServerWebInputException("Partida tem que existir");

		Event event = eventMapper.toEntity(dto);

		event.setPartida(partidaId);
		event.setTipo(eventType.toString());

		event = eventService.salvar(event);
		EventResponseDTO eventResponseDTO = eventMapper.eventToEventResponseDTO(event);

		eventService.sendMessage(event);
		return eventResponseDTO;
	}
}
