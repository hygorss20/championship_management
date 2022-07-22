package com.championship.repository;

import com.championship.domain.model.Players;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PlayersRepository extends JpaRepository<Players, Long>{

}
