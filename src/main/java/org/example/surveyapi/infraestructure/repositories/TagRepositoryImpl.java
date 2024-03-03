package org.example.surveyapi.infraestructure.repositories;

import jakarta.persistence.EntityNotFoundException;
import org.example.surveyapi.domain.models.Tag;
import org.example.surveyapi.domain.repositories.ITagRepository;
import org.example.surveyapi.infraestructure.mapper.ITagMapper;
import org.example.surveyapi.infraestructure.persistance.entities.TagEntity;
import org.example.surveyapi.infraestructure.repositories.jpa.ITagRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TagRepositoryImpl implements ITagRepository {

    @Autowired
    private ITagRepositoryJpa tagRepositoryJpa;

    @Autowired
    private ITagMapper mapper;

    @Override
    public Tag save(Tag entity) {
        TagEntity tagEntity = mapper.toEntity(entity);
        return mapper.toDomain(tagRepositoryJpa.save(tagEntity));
    }

    @Override
    public void delete(Tag entity) {
        tagRepositoryJpa.delete(mapper.toEntity(entity));
    }

    @Override
    public Tag findById(Long id) {
        return mapper.toDomain(tagRepositoryJpa.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public List<Tag> findAll() {
        return tagRepositoryJpa.findAll().stream()
                .map(mapper::toDomain).toList();
    }

    @Override
    public Tag findByName(String name) {
        TagEntity tagEntity = tagRepositoryJpa.findByName(name).orElseThrow(EntityNotFoundException::new);
        return mapper.toDomain(tagEntity);
    }
}
