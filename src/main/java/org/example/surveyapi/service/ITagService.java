package org.example.surveyapi.service;

import org.example.surveyapi.persistance.entities.Tag;
import org.example.surveyapi.web.dtos.request.TagRequest;

public interface ITagService {
    Tag upsert(TagRequest tagRequest);

}