package org.example.surveyapi.infraestructure.repositories;

import jakarta.persistence.EntityNotFoundException;
import org.example.surveyapi.domain.models.Question;
import org.example.surveyapi.domain.repositories.IQuestionRepository;
import org.example.surveyapi.infraestructure.mapper.IQuestionMapper;
import org.example.surveyapi.infraestructure.persistance.entities.QuestionEntity;
import org.example.surveyapi.infraestructure.repositories.jpa.IQuestionRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionRepositoryImpl implements IQuestionRepository {

    @Autowired
    private IQuestionRepositoryJpa questionRepository;

    @Autowired
    private IQuestionMapper mapper;

    @Override
    public Question save(Question entity) {
        QuestionEntity questionEntity = questionRepository.save(mapper.toEntity(entity));
        return mapper.toDomain(questionEntity);
    }

    @Override
    public void delete(Question entity) {
        questionRepository.delete(mapper.toEntity(entity));
    }

    @Override
    public Question findById(Long id) {
        QuestionEntity questionEntity = questionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return mapper.toDomain(questionEntity);
    }

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll().stream()
                .map(mapper::toDomain).toList();
    }
}
