package org.example.surveyapi.service.impl;

import org.example.surveyapi.persistance.entities.Recommendation;
import org.example.surveyapi.persistance.entities.Survey;
import org.example.surveyapi.persistance.repositories.IRecommendationRepository;
import org.example.surveyapi.service.IRecommendationService;
import org.example.surveyapi.service.ITagService;
import org.example.surveyapi.web.dtos.request.RecommendationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommendationServiceImpl implements IRecommendationService {

    @Autowired
    private IRecommendationRepository repository;

    @Autowired
    private ITagService tagService;

    @Override
    public void save(RecommendationRequest recommendationRequest, Survey savedSurvey) {
        Recommendation recommendation = toRecommendation(recommendationRequest);

        recommendation.setTag(tagService.upsert(recommendationRequest.getTag()));
        recommendation.setSurvey(savedSurvey);

        repository.save(recommendation);
    }


    private Recommendation toRecommendation(RecommendationRequest recommendationRequest) {
        Recommendation recommendation = new Recommendation();

        recommendation.setTitle(recommendationRequest.getTitle());
        recommendation.setDescription(recommendationRequest.getDescription());

        return recommendation;
    }
}
