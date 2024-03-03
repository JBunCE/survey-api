package org.example.surveyapi.application.survey.management.service;

import org.example.surveyapi.infraestructure.persistance.entities.TagEntity;
import org.example.surveyapi.domain.models.Tag;

public interface ITagService {
    TagEntity upsert(Tag tag);

}