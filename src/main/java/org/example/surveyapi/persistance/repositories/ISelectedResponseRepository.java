package org.example.surveyapi.persistance.repositories;

import org.example.surveyapi.persistance.entities.SelectedResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISelectedResponseRepository extends JpaRepository<SelectedResponse, Long> {
}
