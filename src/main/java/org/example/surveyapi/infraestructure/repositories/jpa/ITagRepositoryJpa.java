package org.example.surveyapi.infraestructure.repositories.jpa;

import org.example.surveyapi.infraestructure.persistance.entities.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITagRepositoryJpa extends JpaRepository<TagEntity, Long> {

    Optional<TagEntity> findByName(String name);

}
