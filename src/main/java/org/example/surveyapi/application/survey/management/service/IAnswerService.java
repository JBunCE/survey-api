package org.example.surveyapi.application.survey.management.service;


import org.example.surveyapi.domain.models.Question;
import org.example.surveyapi.infraestructure.persistance.entities.QuestionEntity;
import org.example.surveyapi.domain.models.Answer;

public interface IAnswerService {

    void save(Answer request, Question savedQuestionEntity);

}