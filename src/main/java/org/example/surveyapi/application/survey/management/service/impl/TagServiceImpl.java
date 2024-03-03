package org.example.surveyapi.application.survey.management.service.impl;

import org.example.surveyapi.infraestructure.persistance.entities.TagEntity;
import org.example.surveyapi.infraestructure.repositories.jpa.ITagRepositoryJpa;
import org.example.surveyapi.application.survey.management.service.ITagService;
import org.example.surveyapi.domain.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements ITagService {

    @Autowired
    private ITagRepositoryJpa repository;

    @Override
    public TagEntity upsert(Tag tag) {
        TagEntity tagEntity = repository.findByName(tag.getName()).orElse(new TagEntity());
        tagEntity.setName(tag.getName());
        return repository.save(tagEntity);
    }
}
