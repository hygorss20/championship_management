package com.championship.domain.mapper;

import org.mapstruct.Mapper;

import com.championship.domain.dto.EventDTO;
import com.championship.domain.dto.EventResponseDTO;
import com.championship.domain.model.Event;

@Mapper(componentModel = "spring")
public interface EventMapper extends ApplicationMapper<Event, EventDTO> {

	EventResponseDTO eventToEventResponseDTO(Event dto);
	
	Event eventResponseDTOToEvent(EventResponseDTO dto);
}
