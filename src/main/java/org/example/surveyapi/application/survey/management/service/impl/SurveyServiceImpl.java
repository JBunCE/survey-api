package org.example.surveyapi.application.survey.management.service.impl;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.example.surveyapi.application.user.managment.service.IUserService;
import org.example.surveyapi.domain.models.Survey;
import org.example.surveyapi.domain.repositories.ISurveyRepository;
import org.example.surveyapi.infraestructure.persistance.entities.SurveyEntity;
import org.example.surveyapi.infraestructure.persistance.entities.UserEntity;
import org.example.surveyapi.infraestructure.repositories.jpa.ISurveyRepositoryJpa;
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
    private ISurveyRepository repository;

    @Autowired
    private IQuestionService questionService;

    @Autowired
    private IRecommendationService recommendationService;

    @Override
    public BaseResponse get(Long surveyId) {
        Survey survey = repository.findById(surveyId);

        return BaseResponse.builder()
                .message("survey with id: " + surveyId)
                .data(survey)
                .success(Boolean.TRUE)
                .statusCode(200)
                .status(HttpStatus.OK).build();
    }

    @Override
    public BaseResponse create(Survey survey) {
        Survey savedSurvey = repository.save(survey);

        survey.getRecommendations().forEach(request -> recommendationService.save(request, savedSurvey));
        survey.getQuestions().forEach(request -> questionService.save(request, savedSurvey));

        return BaseResponse.builder()
                .message("The survey has been saved with id: " + savedSurvey)
                .data(savedSurvey)
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
        Survey survey = repository.findById(surveyId);
        repository.delete(survey);

        return BaseResponse.builder()
                .data(survey)
                .message("The survey has been deleted")
                .success(Boolean.TRUE)
                .statusCode(200)
                .status(HttpStatus.OK).build();
    }

}