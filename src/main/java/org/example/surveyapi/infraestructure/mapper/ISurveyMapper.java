package org.example.surveyapi.infraestructure.mapper;

import org.example.surveyapi.domain.models.Question;
import org.example.surveyapi.domain.models.Survey;
import org.example.surveyapi.infraestructure.persistance.entities.QuestionEntity;
import org.example.surveyapi.infraestructure.persistance.entities.SurveyEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {IUserMapper.class, IQuestionMapper.class}
)
public interface ISurveyMapper {
    Survey toDomain(SurveyEntity surveyEntity);
    SurveyEntity toEntity(Survey survey);
    List<QuestionEntity> toEntity(List<Question> questions);
    List<Question> toDomain(List<QuestionEntity> questions);
}
