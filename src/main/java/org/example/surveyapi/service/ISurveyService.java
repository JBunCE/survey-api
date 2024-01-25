package org.example.surveyapi.service;

import org.example.surveyapi.web.dtos.BaseResponse;
import org.example.surveyapi.web.dtos.request.SurveyRequest;

public interface ISurveyService {

    BaseResponse get(Long surveyID);

    BaseResponse create(SurveyRequest SurveyRequest);

    BaseResponse update(SurveyRequest SurveyRequest, Long surveyID);

    BaseResponse delete(Long surveyID);

}
