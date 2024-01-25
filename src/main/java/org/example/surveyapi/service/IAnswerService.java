package org.example.surveyapi.service;


import org.example.surveyapi.persistance.entities.Question;
import org.example.surveyapi.web.dtos.request.AnswerRequest;

public interface IAnswerService {

    void save(AnswerRequest request, Question savedQuestion);

}