package org.example.surveyapi.infraestructure.repositories;

import jakarta.persistence.EntityNotFoundException;
import org.example.surveyapi.domain.models.Survey;
import org.example.surveyapi.domain.repositories.ISurveyRepository;
import org.example.surveyapi.infraestructure.mapper.ISurveyMapper;
import org.example.surveyapi.infraestructure.persistance.entities.SurveyEntity;
import org.example.surveyapi.infraestructure.repositories.jpa.ISurveyRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SurveyRepositoryImpl implements ISurveyRepository {

    @Autowired
    private ISurveyRepositoryJpa surveyRepositoryJpa;

    @Autowired
    private ISurveyMapper mapper;

    @Override
    public Survey save(Survey entity) {
        SurveyEntity surveyEntity = mapper.toEntity(entity);
        return mapper.toDomain(surveyRepositoryJpa.save(surveyEntity));
    }

    @Override
    public void delete(Survey entity) {
        surveyRepositoryJpa.delete(mapper.toEntity(entity));
    }

    @Override
    public Survey findById(Long id) {
        return mapper.toDomain(surveyRepositoryJpa.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public List<Survey> findAll() {
        return surveyRepositoryJpa.findAll().stream().map(mapper::toDomain).toList();
    }
}
