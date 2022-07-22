package com.championship.repository;

import com.championship.domain.model.Teams;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TeamsRepository extends JpaRepository<Teams, Long> {
	
	Optional<Teams> findByNome(String nome);

}
