package org.example.surveyapi.persistance.repositories;

import org.example.surveyapi.persistance.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
