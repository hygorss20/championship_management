package com.championship.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.championship.domain.model.Event;


public interface EventRepository extends JpaRepository<Event, Long>{

}
