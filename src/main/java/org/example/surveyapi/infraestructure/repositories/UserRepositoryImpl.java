package org.example.surveyapi.infraestructure.repositories;

import jakarta.persistence.EntityNotFoundException;
import org.example.surveyapi.domain.models.User;
import org.example.surveyapi.domain.repositories.IUserRepository;
import org.example.surveyapi.infraestructure.mapper.IUserMapper;
import org.example.surveyapi.infraestructure.persistance.entities.UserEntity;
import org.example.surveyapi.infraestructure.repositories.jpa.IUserRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserRepositoryImpl implements IUserRepository {

    @Autowired
    private IUserRepositoryJpa userRepositoryJpa;

    @Autowired
    private IUserMapper userMapper;

    @Override
    public User save(User entity) {
        UserEntity userEntity = userMapper.toEntity(entity);
        return userMapper.toDomain(userRepositoryJpa.save(userEntity));
    }

    @Override
    public void delete(User entity) {
        userRepositoryJpa.delete(userMapper.toEntity(entity));
    }

    @Override
    public User findById(Long id) {
        return userMapper.toDomain(userRepositoryJpa.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public List<User> findAll() {
        return userRepositoryJpa.findAll()
                .stream().map(userMapper::toDomain).toList();
    }
}
