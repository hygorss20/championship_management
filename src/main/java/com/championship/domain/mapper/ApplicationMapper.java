package com.championship.domain.mapper;

import org.mapstruct.MappingTarget;

public interface ApplicationMapper<E, D> {

	void updateEntity(D dto, @MappingTarget E entity);

	void updateDTO(E entity, @MappingTarget D dto);

	D toDTO(E entity);

	E toEntity(D dto);

	E copyEntity(E source, @MappingTarget E target);
	
	D copyDTO(D source, @MappingTarget D target);

}
