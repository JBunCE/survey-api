package org.example.surveyapi.infraestructure.repositories.jpa;

import org.example.surveyapi.infraestructure.persistance.entities.ResponseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IResponseRepositoryJpa extends JpaRepository<ResponseEntity, Long> {
}
