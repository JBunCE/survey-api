package org.example.surveyapi.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.surveyapi.persistance.entities.User;
import org.example.surveyapi.persistance.repositories.IUserRepository;
import org.example.surveyapi.service.IUserServices;
import org.example.surveyapi.web.dtos.BaseResponse;
import org.example.surveyapi.web.dtos.request.UserRequest;
import org.example.surveyapi.web.dtos.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserServices {

    @Autowired
    private IUserRepository repository;

    @Override
    public BaseResponse get(Long id){
        User user = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        return BaseResponse.builder()
                .data(toUserResponse(user))
                .message("User created successfully with id: " + id)
                .success(Boolean.TRUE)
                .status(HttpStatus.OK)
                .statusCode(200).build();
    }

    @Override
    public BaseResponse create(UserRequest userRequest){
        User saveUser = repository.save(toUser(userRequest));

        return BaseResponse.builder()
                .data(toUserResponse(saveUser))
                .message("The user was created successfully whit id: " + saveUser.getUserId())
                .success(Boolean.TRUE)
                .status(HttpStatus.OK)
                .statusCode(200).build();
    }

    @Override
    public BaseResponse update(UserRequest userRequest, Long id){
        User user = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        update(userRequest, user);

        User updateUser = repository.save(user);

        return BaseResponse.builder()
                .data(toUserResponse(updateUser))
                .message("The user was updated successfully")
                .success(Boolean.TRUE)
                .status(HttpStatus.OK)
                .statusCode(200).build();
    }

    @Override
    public BaseResponse delete(Long id){
        User user = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        repository.delete(user);

        return BaseResponse.builder()
                .message("The user with id: " + id + " was deleted successfully")
                .success(Boolean.TRUE)
                .status(HttpStatus.OK)
                .statusCode(200).build();
    }

    private User toUser(UserRequest userRequest){
        User user = new User();

        user.setUsername(userRequest.getUsername());
        user.setName(userRequest.getName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setPassword(userRequest.getPassword());

        return user;
    }

    private UserResponse toUserResponse(User user){
        UserResponse userResponse = new UserResponse();

        userResponse.setUserId(user.getUserId());
        userResponse.setUsername(user.getUsername());
        userResponse.setName(user.getName());
        userResponse.setLastName(user.getLastName());
        userResponse.setEmail(user.getEmail());
        userResponse.setPhoneNumber(user.getPhoneNumber());

        return userResponse;
    }

    private void update(UserRequest userRequest, User user){
        user.setUsername(userRequest.getUsername());
        user.setName(userRequest.getName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setPassword(userRequest.getPassword());
    }

}
