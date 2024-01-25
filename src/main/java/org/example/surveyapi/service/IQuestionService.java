package org.example.surveyapi.service;

import org.example.surveyapi.persistance.entities.Survey;
import org.example.surveyapi.persistance.entities.Tag;
import org.example.surveyapi.web.dtos.request.QuestionRequest;

public interface IQuestionService {
    void save(QuestionRequest questionRequest, Survey savedSurvey);
}
