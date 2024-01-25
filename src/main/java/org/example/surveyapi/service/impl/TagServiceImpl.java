package org.example.surveyapi.service.impl;

import org.example.surveyapi.persistance.entities.Tag;
import org.example.surveyapi.persistance.repositories.ITagRepository;
import org.example.surveyapi.service.ITagService;
import org.example.surveyapi.web.dtos.request.TagRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements ITagService {

    @Autowired
    private ITagRepository repository;

    @Override
    public Tag upsert(TagRequest tagRequest) {
        Tag tag = repository.findByName(tagRequest.getName()).orElse(new Tag());
        tag.setName(tagRequest.getName());
        return repository.save(tag);
    }
}
