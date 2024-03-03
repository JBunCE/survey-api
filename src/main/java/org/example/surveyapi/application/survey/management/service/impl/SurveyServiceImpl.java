package org.example.surveyapi.application.survey.management.service.impl;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.example.surveyapi.domain.models.Survey;
import org.example.surveyapi.infraestructure.persistance.entities.SurveyEntity;
import org.example.surveyapi.infraestructure.persistance.entities.UserEntity;
import org.example.surveyapi.infraestructure.repositories.jpa.ISurveyRepositoryJpa;
import org.example.surveyapi.infraestructure.repositories.jpa.IUserRepositoryJpa;
import org.example.surveyapi.application.survey.management.service.IQuestionService;
import org.example.surveyapi.application.survey.management.service.IRecommendationService;
import org.example.surveyapi.application.survey.management.service.ISurveyService;
import org.example.surveyapi.domain.models.responses.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class SurveyServiceImpl implements ISurveyService {

    @Autowired
    private ISurveyRepositoryJpa repository;

    @Autowired
    private IQuestionService questionService;

    @Autowired
    private IRecommendationService recommendationService;

    @Autowired
    private IUserRepositoryJpa userRepository;

    @Override
    public BaseResponse get(Long surveyId) {
        SurveyEntity surveyEntity = repository.findById(surveyId).orElseThrow(EntityExistsException::new);

        return BaseResponse.builder()
                .message("survey with id: " + surveyId)
                .data(toSurveyResponse(surveyEntity))
                .success(Boolean.TRUE)
                .statusCode(200)
                .status(HttpStatus.OK).build();
    }

    @Override
    public BaseResponse create(Survey survey) {
        SurveyEntity surveyEntity = toSurvey(survey);
        UserEntity author = userRepository.findById(survey.getUserId()).orElseThrow(EntityNotFoundException::new);

        surveyEntity.setUserEntity(author);
        SurveyEntity savedSurveyEntity = repository.save(surveyEntity);

        survey.getRecommendations().forEach(request -> recommendationService.save(request, savedSurveyEntity));
        survey.getQuestions().forEach(request -> questionService.save(request, savedSurveyEntity));

        return BaseResponse.builder()
                .message("The survey has been saved with id: " + savedSurveyEntity.getSurveyId())
                .data(toSurveyResponse(savedSurveyEntity))
                .success(Boolean.TRUE)
                .statusCode(200)
                .status(HttpStatus.OK).build();
    }

    @Override
    public BaseResponse update(Survey Survey, Long surveyID) {
        return null;
    }

    @Override
    public BaseResponse delete(Long surveyId) {
        SurveyEntity surveyEntity = repository.findById(surveyId).orElseThrow(EntityNotFoundException::new);
        repository.delete(surveyEntity);

        return BaseResponse.builder()
                .data(toSurveyResponse(surveyEntity))
                .message("The survey has been deleted")
                .success(Boolean.TRUE)
                .statusCode(200)
                .status(HttpStatus.OK).build();
    }

    private SurveyEntity toSurvey(Survey request) {
        SurveyEntity surveyEntity = new SurveyEntity();

        surveyEntity.setTitle(request.getTitle());
        surveyEntity.setDescription(request.getDescription());

        return surveyEntity;
    }

    private SurveyResponse toSurveyResponse(SurveyEntity surveyEntity) {
        SurveyResponse surveyResponse = new SurveyResponse();

        surveyResponse.setId(surveyResponse.getId());
        surveyResponse.setTitle(surveyEntity.getTitle());
        surveyResponse.setDescription(surveyEntity.getDescription());
        surveyResponse.setAuthorId(surveyEntity.getUserEntity().getUserId());
        surveyResponse.setQuestionEntities(surveyEntity.getQuestionEntities());

        return surveyResponse;
    }

}