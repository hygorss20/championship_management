package com.championship.domain.mapper;

import com.championship.domain.dto.TransfersDTO;
import com.championship.domain.dto.TransfersRequestDTO;
import com.championship.domain.dto.TransfersResponseDTO;
import com.championship.domain.model.Transfers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TransfersMapper extends ApplicationMapper<Transfers, TransfersDTO> {

	TransfersResponseDTO transfersToTransfersResponseDTO(Transfers dto);

	Transfers transfersResponseDTOTOTransfers(TransfersResponseDTO dto);
	
    @Mappings({
        @Mapping(target = "timeOrigem.nome", source = "dto.timeOrigem"),
        @Mapping(target = "timeDestino.nome", source = "dto.timeDestino")
    })
	Transfers transfersRequestDTOTOTransfers(TransfersRequestDTO dto);
}
