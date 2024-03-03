package org.example.surveyapi.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Survey {
    String id;
    String title;
    String description;
    User author;
    List<Question> questions;
    List<Recommendation> recommendations;
}
