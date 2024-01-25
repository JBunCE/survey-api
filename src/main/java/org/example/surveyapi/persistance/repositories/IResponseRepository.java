package org.example.surveyapi.persistance.repositories;

import org.example.surveyapi.persistance.entities.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IResponseRepository extends JpaRepository<Response, Long> {
}
