package org.example.surveyapi.persistance.repositories;

import org.example.surveyapi.persistance.entities.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecommendationRepository extends JpaRepository<Recommendation, Long> {
}
