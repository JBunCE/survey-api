package org.example.surveyapi.infraestructure.repositories.jpa;

import org.example.surveyapi.infraestructure.persistance.entities.SelectedResponseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISelectedResponseRepositoryJpa extends JpaRepository<SelectedResponseEntity, Long> {
}
