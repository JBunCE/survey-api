package org.example.surveyapi.infraestructure.repositories;

import jakarta.persistence.EntityNotFoundException;
import org.example.surveyapi.domain.models.SelectedResponse;
import org.example.surveyapi.domain.repositories.ISelectedResponseRepository;
import org.example.surveyapi.infraestructure.mapper.ISelectedResponseMapper;
import org.example.surveyapi.infraestructure.persistance.entities.SelectedResponseEntity;
import org.example.surveyapi.infraestructure.repositories.jpa.ISelectedResponseRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SelectedResponseRepositoryImpl implements ISelectedResponseRepository {

    @Autowired
    private ISelectedResponseRepositoryJpa selectedResponseRepositoryJpa;

    @Autowired
    private ISelectedResponseMapper mapper;

    @Override
    public SelectedResponse save(SelectedResponse entity) {
        SelectedResponseEntity selectedResponseEntity = mapper.toEntity(entity);
        return mapper.toDomain(selectedResponseRepositoryJpa.save(selectedResponseEntity));
    }

    @Override
    public void delete(SelectedResponse entity) {
        selectedResponseRepositoryJpa.delete(mapper.toEntity(entity));
    }

    @Override
    public SelectedResponse findById(Long id) {
        return mapper.toDomain(selectedResponseRepositoryJpa.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public List<SelectedResponse> findAll() {
        return selectedResponseRepositoryJpa.findAll().stream().map(mapper::toDomain).toList();
    }
}
