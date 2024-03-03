package org.example.surveyapi.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Question {
    private String id;
    private String title;
    private String description;
    private Survey survey;
    private List<Answer> answers;
}
