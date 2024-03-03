package org.example.surveyapi.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Survey {

    String title;

    String description;

    Long userId;

    List<Question> questions;

    List<Recommendation> recommendations;

}
