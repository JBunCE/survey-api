package org.example.surveyapi.infraestructure.mapper;

import org.example.surveyapi.domain.models.Answer;
import org.example.surveyapi.infraestructure.persistance.entities.AnswerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IAnswerMapper {

    Answer toDomain(AnswerEntity answerEntity);

    AnswerEntity toEntity(Answer answer);
}
