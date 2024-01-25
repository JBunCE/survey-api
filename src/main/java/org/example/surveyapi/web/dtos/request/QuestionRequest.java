package org.example.surveyapi.web.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class QuestionRequest {

    private String title;

    private String description;

    private List<AnswerRequest> answers;

}
