package com.championship.repository;

import com.championship.domain.model.Tournaments;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TournametsRepository extends JpaRepository<Tournaments, Long>{

}
