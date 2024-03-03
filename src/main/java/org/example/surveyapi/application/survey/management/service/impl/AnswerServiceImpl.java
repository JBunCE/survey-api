package org.example.surveyapi.application.survey.management.service.impl;

import org.example.surveyapi.domain.models.Question;
import org.example.surveyapi.domain.repositories.IAnswerRepository;
import org.example.surveyapi.infraestructure.persistance.entities.AnswerEntity;
import org.example.surveyapi.infraestructure.persistance.entities.QuestionEntity;
import org.example.surveyapi.infraestructure.persistance.entities.TagEntity;
import org.example.surveyapi.infraestructure.repositories.jpa.IAnswerRepositoryJpa;
import org.example.surveyapi.application.survey.management.service.ITagService;
import org.example.surveyapi.application.survey.management.service.IAnswerService;
import org.example.surveyapi.domain.models.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements IAnswerService {

    @Autowired
    private IAnswerRepository repository;

    @Autowired
    private ITagService tagService;

    @Override
    public void save(Answer request, Question question) {
        tagService.upsert(request.getTag());
        request.setQuestion(question);

        repository.save(request);
    }
}
