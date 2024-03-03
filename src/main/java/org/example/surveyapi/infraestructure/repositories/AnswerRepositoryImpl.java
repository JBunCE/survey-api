package org.example.surveyapi.infraestructure.repositories;

import jakarta.persistence.EntityNotFoundException;
import org.example.surveyapi.domain.models.Answer;
import org.example.surveyapi.domain.repositories.IAnswerRepository;
import org.example.surveyapi.infraestructure.mapper.IAnswerMapper;
import org.example.surveyapi.infraestructure.persistance.entities.AnswerEntity;
import org.example.surveyapi.infraestructure.repositories.jpa.IAnswerRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AnswerRepositoryImpl implements IAnswerRepository {

    @Autowired
    private IAnswerRepositoryJpa answerRepositoryJpa;

    @Autowired
    private IAnswerMapper mapper;

    @Override
    public Answer save(Answer entity) {
        AnswerEntity answerEntity = mapper.toEntity(entity);
        answerEntity = answerRepositoryJpa.save(answerEntity);
        return mapper.toDomain(answerEntity);
    }

    @Override
    public void delete(Answer entity) {
        answerRepositoryJpa.delete(mapper.toEntity(entity));
    }

    @Override
    public Answer findById(Long id) {
        AnswerEntity answer = answerRepositoryJpa.findById(id).orElseThrow(EntityNotFoundException::new);
        return mapper.toDomain(answer);
    }

    @Override
    public List<Answer> findAll() {
        return answerRepositoryJpa
                .findAll().stream()
                .map(mapper::toDomain).toList();
    }
}
