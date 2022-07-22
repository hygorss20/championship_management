package com.championship.domain.mapper;

import com.championship.domain.dto.PlayersDTO;
import com.championship.domain.dto.PlayersResponseDTO;
import com.championship.domain.model.Players;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayersMapper extends ApplicationMapper<Players, PlayersDTO> {

	PlayersResponseDTO playersToPlayersResponseDTO(Players dto);

	Players playersResponseDTOTOPlayers(PlayersResponseDTO dto);
}
