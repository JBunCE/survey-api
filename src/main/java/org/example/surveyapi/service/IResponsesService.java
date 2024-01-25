package org.example.surveyapi.service;

import org.example.surveyapi.web.dtos.BaseResponse;
import org.example.surveyapi.web.dtos.request.ResponseRequest;

public interface IResponsesService {

    BaseResponse getUserById(Long id);

    BaseResponse create(ResponseRequest responseRequest);

    BaseResponse update(ResponseRequest responseRequest, Long id);

    BaseResponse delete(Long id);
    
}