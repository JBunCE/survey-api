package org.example.surveyapi.infraestructure.mapper;

import org.example.surveyapi.domain.models.SelectedResponse;
import org.example.surveyapi.infraestructure.persistance.entities.SelectedResponseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISelectedResponseMapper {

    SelectedResponse toDomain(SelectedResponseEntity selectedResponseEntity);
    SelectedResponseEntity toEntity(SelectedResponse selectedResponse);

}
