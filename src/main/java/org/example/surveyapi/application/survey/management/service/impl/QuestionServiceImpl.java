package org.example.surveyapi.application.survey.management.service.impl;

import org.example.surveyapi.domain.models.Survey;
import org.example.surveyapi.domain.repositories.IQuestionRepository;
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
    private IQuestionRepository repository;

    @Autowired
    private IAnswerService answerService;

    @Override
    public void save(Question question, Survey survey) {
        question.setSurvey(survey);

        Question savedQuestion = repository.save(question);

        question.getAnswers().forEach(answerRequest -> {
            answerService.save(answerRequest, savedQuestion);
        });
    }
}
