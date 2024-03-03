package org.example.surveyapi.application.survey.management.service.impl;

import org.example.surveyapi.infraestructure.persistance.entities.QuestionEntity;
import org.example.surveyapi.infraestructure.persistance.entities.SurveyEntity;
import org.example.surveyapi.infraestructure.repositories.jpa.IQuestionRepositoryJpa;
import org.example.surveyapi.application.survey.management.service.IAnswerService;
import org.example.surveyapi.application.survey.management.service.IQuestionService;
import org.example.surveyapi.domain.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements IQuestionService {

    @Autowired
    private IQuestionRepositoryJpa repository;

    @Autowired
    private IAnswerService answerService;

    @Override
    public void save(Question question, SurveyEntity savedSurveyEntity) {
        QuestionEntity questionEntity = toQuestion(question);
        questionEntity.setSurveyEntity(savedSurveyEntity);

        QuestionEntity savedQuestionEntity = repository.save(questionEntity);

        question.getAnswers().forEach(answerRequest -> {
            answerService.save(answerRequest, savedQuestionEntity);
        });
    }

    private QuestionEntity toQuestion(Question request) {
        QuestionEntity questionEntity = new QuestionEntity();

        questionEntity.setTitle(request.getTitle());
        questionEntity.setDescription(questionEntity.getDescription());

        return questionEntity;
    }
}
