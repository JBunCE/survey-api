package org.example.surveyapi.persistance.repositories;

import org.example.surveyapi.persistance.entities.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISurveyRepository extends JpaRepository<Survey, Long> {
}
