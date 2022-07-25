package com.championship.controller;


import java.util.List;
import java.util.stream.Collectors;

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


//@SecurityRequirement(name = "finalaws")

@RestController
@RequestMapping(value = "/torneios/{torneiroId}/partidas/{partidaId}",  produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Gera eventos da partida.")
public class EventsController {

	@Autowired
	private EventService eventService;
	
	@Autowired
	private final EventMapper eventMapper  = Mappers.getMapper(EventMapper.class);
	
	@PostMapping("/eventos")
	@ApiOperation(value = "Criar um novo evento.")
	public ResponseEntity<EventResponseDTO> inserirEvento(@PathVariable Long torneiroId, @PathVariable Long partidaId, @RequestBody EventDTO dto) {

		// Conferir se torneio existe
		
		// Conferir se partida existe
		
		
		Event event = eventMapper.toEntity(dto);
		
		event.setPartida(partidaId);
		
		event = eventService.salvar(event);
		EventResponseDTO eventResponseDTO = eventMapper.eventToEventResponseDTO(event);
		
		eventService.sendMessage(event);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(eventResponseDTO);
	}
	
	@GetMapping("/eventos")
	@ApiOperation(value = "Listar todos eventos de uma partida.")
	public ResponseEntity<List<EventResponseDTO>> listar() {
		
		// Conferir se torneio existe
		
		// Conferir se partida existe
		
		List<EventResponseDTO> eventList = eventService.listarEvents()
				.stream()
				.map(eventMapper::eventToEventResponseDTO)
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(eventList);
	}
}
