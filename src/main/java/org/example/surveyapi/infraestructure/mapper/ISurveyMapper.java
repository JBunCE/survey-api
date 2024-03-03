package org.example.surveyapi.infraestructure.mapper;

import org.example.surveyapi.domain.models.Survey;
import org.example.surveyapi.infraestructure.persistance.entities.SurveyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISurveyMapper {
    Survey toDomain(SurveyEntity surveyEntity);
    SurveyEntity toEntity(Survey survey);
}
