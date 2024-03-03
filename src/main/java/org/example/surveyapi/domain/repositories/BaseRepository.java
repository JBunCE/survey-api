package org.example.surveyapi.domain.repositories;

import java.util.List;

public interface BaseRepository<T> {

    T save(T entity);
    void delete(T entity);
    T findById(Long id);
    List<T> findAll();

}
