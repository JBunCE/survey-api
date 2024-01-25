package org.example.surveyapi.service.impl;

import org.example.surveyapi.persistance.entities.Answer;
import org.example.surveyapi.persistance.entities.Question;
import org.example.surveyapi.persistance.entities.Tag;
import org.example.surveyapi.persistance.repositories.IAnswerRepository;
import org.example.surveyapi.service.IAnswerService;
import org.example.surveyapi.service.ITagService;
import org.example.surveyapi.web.dtos.request.AnswerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements IAnswerService {

    @Autowired
    private IAnswerRepository repository;

    @Autowired
    private ITagService tagService;

    @Override
    public void save(AnswerRequest request, Question savedQuestion) {
        Answer answer = toAnswer(request);
        Tag tag = tagService.upsert(request.getTag());

        answer.setQuestion(savedQuestion);
        answer.setTag(tag);

        repository.save(answer);
    }

    private Answer toAnswer(AnswerRequest request) {
        Answer answer = new Answer();

        answer.setTitle(request.getTitle());
        answer.setIndex(request.getIndex());
        answer.setPoints(request.getPoints());

        return answer;
    }
}
