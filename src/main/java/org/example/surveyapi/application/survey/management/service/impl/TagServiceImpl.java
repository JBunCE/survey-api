package org.example.surveyapi.application.survey.management.service.impl;

import org.example.surveyapi.domain.repositories.ITagRepository;
import org.example.surveyapi.infraestructure.persistance.entities.TagEntity;
import org.example.surveyapi.infraestructure.repositories.jpa.ITagRepositoryJpa;
import org.example.surveyapi.application.survey.management.service.ITagService;
import org.example.surveyapi.domain.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements ITagService {

    @Autowired
    private ITagRepository repository;

    @Override
    public Tag upsert(Tag tag) {
        Tag tagEntity = repository.findByName(tag.getName());
        tagEntity.setName(tag.getName());
        return repository.save(tagEntity);
    }
}
