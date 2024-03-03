package org.example.surveyapi.application.survey.management.service;

import org.example.surveyapi.domain.models.responses.BaseResponse;
import org.example.surveyapi.domain.models.responses.ResponseRequest;

public interface IResponsesService {

    BaseResponse getUserById(Long id);

    BaseResponse create(ResponseRequest responseRequest);

    BaseResponse update(ResponseRequest responseRequest, Long id);

    BaseResponse delete(Long id);
    
}