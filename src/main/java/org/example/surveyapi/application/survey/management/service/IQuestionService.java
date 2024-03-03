package org.example.surveyapi.application.survey.management.service;

import org.example.surveyapi.infraestructure.persistance.entities.SurveyEntity;
import org.example.surveyapi.domain.models.Question;

public interface IQuestionService {
    void save(Question question, SurveyEntity savedSurveyEntity);
}
