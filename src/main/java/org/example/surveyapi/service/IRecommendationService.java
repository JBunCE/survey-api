package org.example.surveyapi.service;

import org.example.surveyapi.persistance.entities.Survey;
import org.example.surveyapi.web.dtos.request.RecommendationRequest;

public interface IRecommendationService {

    void save(RecommendationRequest recommendationRequest, Survey savedSurvey);

}