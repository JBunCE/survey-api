package org.example.surveyapi.infraestructure.mapper;

import org.example.surveyapi.domain.models.Question;
import org.example.surveyapi.infraestructure.persistance.entities.QuestionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IQuestionMapper {

    Question toDomain(QuestionEntity questionEntity);

    QuestionEntity toEntity(Question question);

}
