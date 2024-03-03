package org.example.surveyapi.application.survey.management.service.impl;

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
    private IRecommendationRepositoryJpa repository;

    @Autowired
    private ITagService tagService;

    @Override
    public void save(Recommendation recommendation, SurveyEntity savedSurveyEntity) {
        RecommendationEntity recommendationEntity = toRecommendation(recommendation);

        recommendationEntity.setTagEntity(tagService.upsert(recommendation.getTag()));
        recommendationEntity.setSurveyEntity(savedSurveyEntity);

        repository.save(recommendationEntity);
    }


    private RecommendationEntity toRecommendation(Recommendation recommendation) {
        RecommendationEntity recommendationEntity = new RecommendationEntity();

        recommendationEntity.setTitle(recommendation.getTitle());
        recommendationEntity.setDescription(recommendation.getDescription());

        return recommendationEntity;
    }
}
