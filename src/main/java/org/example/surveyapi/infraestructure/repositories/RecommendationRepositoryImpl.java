package org.example.surveyapi.infraestructure.repositories;

import jakarta.persistence.EntityExistsException;
import org.example.surveyapi.domain.models.Recommendation;
import org.example.surveyapi.domain.repositories.IRecommendationRepository;
import org.example.surveyapi.infraestructure.mapper.IRecommendationMapper;
import org.example.surveyapi.infraestructure.persistance.entities.RecommendationEntity;
import org.example.surveyapi.infraestructure.repositories.jpa.IRecommendationRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecommendationRepositoryImpl implements IRecommendationRepository {

    @Autowired
    private IRecommendationRepositoryJpa recommendationRepositoryJpa;

    @Autowired
    private IRecommendationMapper mapper;

    @Override
    public Recommendation save(Recommendation entity) {
        RecommendationEntity recommendationEntity = mapper.toEntity(entity);
        return mapper.toDomain(recommendationRepositoryJpa.save(recommendationEntity));
    }

    @Override
    public void delete(Recommendation entity) {
        recommendationRepositoryJpa.delete(mapper.toEntity(entity));
    }

    @Override
    public Recommendation findById(Long id) {
        RecommendationEntity recommendationEntity = recommendationRepositoryJpa
                .findById(id).orElseThrow(EntityExistsException::new);

        return mapper.toDomain(recommendationEntity);
    }

    @Override
    public List<Recommendation> findAll() {
        return recommendationRepositoryJpa.findAll()
                .stream().map(mapper::toDomain).toList();
    }
}
