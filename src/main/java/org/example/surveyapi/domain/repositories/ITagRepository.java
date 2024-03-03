package org.example.surveyapi.domain.repositories;

import org.example.surveyapi.domain.models.Tag;

import java.util.Optional;

public interface ITagRepository extends BaseRepository<Tag> {

    Tag findByName(String name);

}
