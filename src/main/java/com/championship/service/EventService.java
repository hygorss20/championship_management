package com.championship.service;

import java.util.List;

import com.championship.domain.model.Event;


public interface EventService {

	Event salvar(Event events);
	List<Event> listarEvents();	
	void sendMessage(Event event);

}
