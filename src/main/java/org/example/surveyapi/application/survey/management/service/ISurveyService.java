package org.example.surveyapi.application.survey.management.service;

import org.example.surveyapi.domain.models.responses.BaseResponse;
import org.example.surveyapi.domain.models.Survey;

public interface ISurveyService {

    BaseResponse get(Long surveyID);

    BaseResponse create(Survey Survey);

    BaseResponse update(Survey Survey, Long surveyID);

    BaseResponse delete(Long surveyID);

}
