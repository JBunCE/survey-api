package org.example.surveyapi.application.user.managment.service.impl;

import lombok.NonNull;
import org.example.surveyapi.domain.repositories.IUserRepository;
import org.example.surveyapi.application.user.managment.service.IUserServices;
import org.example.surveyapi.domain.models.responses.BaseResponse;
import org.example.surveyapi.domain.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserServices {

    @Autowired
    private IUserRepository repository;

    @Override
    public BaseResponse get(Long id){
        return BaseResponse.builder()
                .data(repository.findById(id))
                .message("User created successfully with id: " + id)
                .success(Boolean.TRUE)
                .status(HttpStatus.OK)
                .statusCode(200).build();
    }

    @Override
    public BaseResponse create(@NonNull User user){
        return BaseResponse.builder()
                .data(repository.save(user))
                .message("The user was created successfully")
                .success(Boolean.TRUE)
                .status(HttpStatus.OK)
                .statusCode(200).build();
    }

    @Override
    public BaseResponse update(User user, Long id) {
        return null;
    }

    @Override
    public BaseResponse delete(Long id){
        repository.delete(repository.findById(id));
        return BaseResponse.builder()
                .message("The user with id: " + id + " was deleted successfully")
                .success(Boolean.TRUE)
                .status(HttpStatus.OK)
                .statusCode(200).build();
    }

    @Override
    public User findOneAndEnsureExists(Long id) {
        return null;
    }
}
