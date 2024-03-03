package org.example.surveyapi.infraestructure.mapper;

import org.example.surveyapi.domain.models.Question;
import org.example.surveyapi.infraestructure.persistance.entities.QuestionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {IAnswerMapper.class, ISurveyMapper.class})
public interface IQuestionMapper {

    @Mapping(target = "survey", ignore = true)
    Question toDomain(QuestionEntity questionEntity);

    QuestionEntity toEntity(Question question);
}
