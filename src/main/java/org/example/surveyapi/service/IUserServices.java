package org.example.surveyapi.service;

import org.example.surveyapi.web.dtos.BaseResponse;
import org.example.surveyapi.web.dtos.request.UserRequest;

public interface IUserServices {

    BaseResponse get(Long id);

    BaseResponse create(UserRequest userRequest);

    BaseResponse update(UserRequest userRequest, Long id);

    BaseResponse delete(Long id);
}
