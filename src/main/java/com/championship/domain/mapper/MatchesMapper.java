package com.championship.domain.mapper;


import com.championship.domain.dto.MatchesDTO;
import com.championship.domain.dto.TournamentsDTO;
import com.championship.domain.model.Matches;
import com.championship.domain.model.Tournaments;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MatchesMapper extends ApplicationMapper<Matches, MatchesDTO> {

	MatchesDTO matchesToMatchesDTO(Matches dto);

	Matches matchedDtoToMatches(MatchesDTO dto);
}
