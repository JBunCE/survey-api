package org.example.surveyapi.application.user.managment.service;

import org.example.surveyapi.domain.models.responses.BaseResponse;
import org.example.surveyapi.domain.models.User;

public interface IUserService {
    BaseResponse get(Long id);
    BaseResponse create(User user);
    BaseResponse update(User user, Long id);
    BaseResponse delete(Long id);
    User findOneAndEnsureExists(Long id);
}
