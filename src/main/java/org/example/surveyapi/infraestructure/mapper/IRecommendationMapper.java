package org.example.surveyapi.infraestructure.mapper;

import org.example.surveyapi.domain.models.Recommendation;
import org.example.surveyapi.infraestructure.persistance.entities.RecommendationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IRecommendationMapper {

    Recommendation toDomain(RecommendationEntity recommendationEntity);
    RecommendationEntity toEntity(Recommendation recommendation);

}
