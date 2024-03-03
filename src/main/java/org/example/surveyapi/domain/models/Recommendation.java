package org.example.surveyapi.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Recommendation {
    private String id;
    private String title;
    private String description;
    private Tag tag;
    private Survey survey;

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }
}
