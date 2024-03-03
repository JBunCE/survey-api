package org.example.surveyapi.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Question {

    private String title;

    private String description;

    private List<Answer> answers;

}
