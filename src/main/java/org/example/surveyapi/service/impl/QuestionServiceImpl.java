package org.example.surveyapi.service.impl;

import org.example.surveyapi.persistance.entities.Question;
import org.example.surveyapi.persistance.entities.Survey;
import org.example.surveyapi.persistance.entities.Tag;
import org.example.surveyapi.persistance.repositories.IQuestionRepository;
import org.example.surveyapi.service.IAnswerService;
import org.example.surveyapi.service.IQuestionService;
import org.example.surveyapi.web.dtos.request.QuestionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements IQuestionService {

    @Autowired
    private IQuestionRepository repository;

    @Autowired
    private IAnswerService answerService;

    @Override
    public void save(QuestionRequest questionRequest, Survey savedSurvey) {
        Question question = toQuestion(questionRequest);
        question.setSurvey(savedSurvey);

        Question savedQuestion = repository.save(question);

        questionRequest.getAnswers().forEach(answerRequest -> {
            answerService.save(answerRequest, savedQuestion);
        });
    }

    private Question toQuestion(QuestionRequest request) {
        Question question = new Question();

        question.setTitle(request.getTitle());
        question.setDescription(question.getDescription());

        return question;
    }
}
