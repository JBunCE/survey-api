package org.example.surveyapi.application.survey.management.service.impl;

import org.example.surveyapi.domain.models.Survey;
import org.example.surveyapi.domain.repositories.IRecommendationRepository;
import org.example.surveyapi.infraestructure.persistance.entities.RecommendationEntity;
import org.example.surveyapi.infraestructure.persistance.entities.SurveyEntity;
import org.example.surveyapi.infraestructure.repositories.jpa.IRecommendationRepositoryJpa;
import org.example.surveyapi.application.survey.management.service.ITagService;
import org.example.surveyapi.application.survey.management.service.IRecommendationService;
import org.example.surveyapi.domain.models.Recommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommendationServiceImpl implements IRecommendationService {

    @Autowired
    private IRecommendationRepository repository;

    @Autowired
    private ITagService tagService;

    @Override
    public void save(Recommendation request, Survey savedSurvey) {
        request.setSurvey(savedSurvey);
        request.setTag(tagService.upsert(request.getTag()));

        repository.save(request);
    }
}
