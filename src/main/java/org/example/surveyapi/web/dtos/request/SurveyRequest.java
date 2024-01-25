package org.example.surveyapi.web.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class SurveyRequest {

    String title;

    String description;

    Long userId;

    List<QuestionRequest> questionRequests;

    List<RecommendationRequest> recommendationRequests;

}
