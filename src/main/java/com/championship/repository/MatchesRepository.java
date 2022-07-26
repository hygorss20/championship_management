package com.championship.repository;

import com.championship.domain.model.Matches;
import com.championship.domain.model.Tournaments;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MatchesRepository extends JpaRepository<Matches, Long>{

}
