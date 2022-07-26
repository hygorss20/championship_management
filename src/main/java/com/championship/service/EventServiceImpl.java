package com.championship.service;

import java.util.List;

import org.hibernate.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.championship.domain.model.Event;
import com.championship.exception.ViolacaoDeRegraEx;
import com.championship.rabbitmq.Producer;
import com.championship.repository.EventRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.server.ServerWebInputException;

@Service("EventService")
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private Producer producer;

	@Override
	public Event salvar(Event event) {
		
		if(StringHelper.isEmpty(event.getTipo()))
			throw new ServerWebInputException("Tipo do evento não pode ser vazio");
		
		return eventRepository.save(event);
	}

	@Override
	public List<Event> listarEvents() {
		return eventRepository.findAll();
	}

	@Override
	public void sendMessage(Event event) {
		System.out.println("Send message!");
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			String json = objectMapper.writeValueAsString(event);
			
			producer.sendMsg(json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}		
	}
}
