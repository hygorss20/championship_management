package com.championship.domain.mapper;

import com.championship.domain.dto.TeamsResponseDTO;
import com.championship.domain.dto.TeamsDTO;
import com.championship.domain.model.Teams;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamsMapper extends ApplicationMapper<Teams, TeamsDTO> {

    TeamsResponseDTO teamsToTeamsResponseDTO(Teams dto);

    Teams teamsResponseDTOTOTeams(TeamsResponseDTO dto);
}
