package org.example.surveyapi.service.impl;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.example.surveyapi.persistance.entities.Survey;
import org.example.surveyapi.persistance.entities.User;
import org.example.surveyapi.persistance.repositories.ISurveyRepository;
import org.example.surveyapi.persistance.repositories.IUserRepository;
import org.example.surveyapi.service.IQuestionService;
import org.example.surveyapi.service.IRecommendationService;
import org.example.surveyapi.service.ISurveyService;
import org.example.surveyapi.web.dtos.BaseResponse;
import org.example.surveyapi.web.dtos.request.SurveyRequest;
import org.example.surveyapi.web.dtos.response.SurveyResponse;
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

    @Autowired
    private IUserRepository userRepository;

    @Override
    public BaseResponse get(Long surveyId) {
        Survey survey = repository.findById(surveyId).orElseThrow(EntityExistsException::new);

        return BaseResponse.builder()
                .message("survey with id: " + surveyId)
                .data(toSurveyResponse(survey))
                .success(Boolean.TRUE)
                .statusCode(200)
                .status(HttpStatus.OK).build();
    }

    @Override
    public BaseResponse create(SurveyRequest surveyRequest) {
        Survey survey = toSurvey(surveyRequest);
        User author = userRepository.findById(surveyRequest.getUserId()).orElseThrow(EntityNotFoundException::new);

        survey.setUser(author);
        Survey savedSurvey = repository.save(survey);

        surveyRequest.getRecommendationRequests().forEach(request -> recommendationService.save(request, savedSurvey));
        surveyRequest.getQuestionRequests().forEach(request -> questionService.save(request, savedSurvey));

        return BaseResponse.builder()
                .message("The survey has been saved with id: " + savedSurvey.getSurveyId())
                .data(toSurveyResponse(savedSurvey))
                .success(Boolean.TRUE)
                .statusCode(200)
                .status(HttpStatus.OK).build();
    }

    @Override
    public BaseResponse update(SurveyRequest SurveyRequest, Long surveyID) {
        return null;
    }

    @Override
    public BaseResponse delete(Long surveyId) {
        Survey survey = repository.findById(surveyId).orElseThrow(EntityNotFoundException::new);
        repository.delete(survey);

        return BaseResponse.builder()
                .data(toSurveyResponse(survey))
                .message("The survey has been deleted")
                .success(Boolean.TRUE)
                .statusCode(200)
                .status(HttpStatus.OK).build();
    }

    private Survey toSurvey(SurveyRequest request) {
        Survey survey = new Survey();

        survey.setTitle(request.getTitle());
        survey.setDescription(request.getDescription());

        return survey;
    }

    private SurveyResponse toSurveyResponse(Survey survey) {
        SurveyResponse surveyResponse = new SurveyResponse();

        surveyResponse.setId(surveyResponse.getId());
        surveyResponse.setTitle(survey.getTitle());
        surveyResponse.setDescription(survey.getDescription());
        surveyResponse.setAuthorId(survey.getUser().getUserId());
        surveyResponse.setQuestions(survey.getQuestions());

        return surveyResponse;
    }

}