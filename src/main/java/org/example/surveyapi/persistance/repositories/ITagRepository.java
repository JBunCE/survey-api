package org.example.surveyapi.persistance.repositories;

import org.example.surveyapi.persistance.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITagRepository extends JpaRepository<Tag, Long> {

    Optional<Tag> findByName(String name);

}
