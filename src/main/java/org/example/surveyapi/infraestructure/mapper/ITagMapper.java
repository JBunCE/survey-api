package org.example.surveyapi.infraestructure.mapper;

import org.example.surveyapi.domain.models.Tag;
import org.example.surveyapi.infraestructure.persistance.entities.TagEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ITagMapper {
    Tag toDomain(TagEntity entity);
    TagEntity toEntity(Tag domain);
}
