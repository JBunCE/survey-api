package org.example.surveyapi.infraestructure.mapper;

import org.example.surveyapi.domain.models.User;
import org.example.surveyapi.infraestructure.persistance.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserMapper {
    User toDomain(UserEntity userEntity);
    UserEntity toEntity(User user);
}
