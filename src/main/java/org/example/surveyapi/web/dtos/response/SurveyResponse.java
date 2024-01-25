package org.example.surveyapi.web.dtos.response;

import lombok.Getter;
import lombok.Setter;
import org.example.surveyapi.persistance.entities.Question;

import java.util.List;
import java.util.Set;

@Getter @Setter
public class SurveyResponse {

    private Long id;

    private String title;

    private String description;

    private Long authorId;

    private Set<Question> questions;

}
