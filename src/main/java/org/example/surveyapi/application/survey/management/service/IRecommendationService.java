package org.example.surveyapi.application.survey.management.service;

import org.example.surveyapi.infraestructure.persistance.entities.SurveyEntity;
import org.example.surveyapi.domain.models.Recommendation;

public interface IRecommendationService {

    void save(Recommendation recommendation, SurveyEntity savedSurveyEntity);

}