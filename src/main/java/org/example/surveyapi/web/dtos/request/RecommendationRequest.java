package org.example.surveyapi.web.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RecommendationRequest {

    private String title;

    private String description;

    private TagRequest tag;

}
