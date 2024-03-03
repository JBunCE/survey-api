package org.example.surveyapi.application.survey.management.service.impl;

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
    private IAnswerRepositoryJpa repository;

    @Autowired
    private ITagService tagService;

    @Override
    public void save(Answer request, QuestionEntity savedQuestionEntity) {
        AnswerEntity answerEntity = toAnswer(request);
        TagEntity tagEntity = tagService.upsert(request.getTag());

        answerEntity.setQuestionEntity(savedQuestionEntity);
        answerEntity.setTagEntity(tagEntity);

        repository.save(answerEntity);
    }

    private AnswerEntity toAnswer(Answer request) {
        AnswerEntity answerEntity = new AnswerEntity();

        answerEntity.setTitle(request.getTitle());
        answerEntity.setIndex(request.getIndex());
        answerEntity.setPoints(request.getPoints());

        return answerEntity;
    }
}
