package com.championship.domain.mapper;


import org.mapstruct.Mapper;

import com.championship.domain.dto.TournamentsDTO;
import com.championship.domain.model.Tournaments;

@Mapper(componentModel = "spring")
public interface TournamentsMapper extends ApplicationMapper<Tournaments, TournamentsDTO> {

	TournamentsDTO tournamentsToTournamentsResponseDTO(Tournaments dto);

	Tournaments tournamentsResponseDTOTOPlayers(TournamentsDTO dto);
}
