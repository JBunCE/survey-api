package org.example.surveyapi.web.dtos.request;

import lombok.Getter;
import lombok.Setter;
import org.example.surveyapi.persistance.enums.Index;

@Getter @Setter
public class AnswerRequest {

    private String title;

    private Integer points;

    private Index index;

    private TagRequest tag;

}
