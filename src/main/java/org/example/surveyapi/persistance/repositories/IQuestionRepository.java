package org.example.surveyapi.persistance.repositories;

import org.example.surveyapi.persistance.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionRepository extends JpaRepository<Question, Long> {
}
