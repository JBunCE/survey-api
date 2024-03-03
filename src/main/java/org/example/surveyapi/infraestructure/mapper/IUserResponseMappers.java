package org.example.surveyapi.infraestructure.mapper;

import org.example.surveyapi.domain.models.User;
import org.example.surveyapi.domain.models.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserResponseMappers {
    UserResponse toUserResponse(User user);

}
