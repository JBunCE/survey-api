package org.example.surveyapi.domain.models;

import lombok.Getter;
import lombok.Setter;
import org.example.surveyapi.domain.models.value.objects.Index;

@Getter @Setter
public class Answer {
    private String id;
    private String title;
    private Integer points;
    private Index index;
    private Tag tag;
    private Question question;
}
