package org.example.surveyapi.infraestructure.persistance.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "questions")
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "survey_id", nullable = false)
    private SurveyEntity surveyEntity;

    @OneToMany(mappedBy = "question")
    private Set<AnswerEntity> answerEntities;

    @OneToMany(mappedBy = "question")
    private Set<SelectedResponseEntity> responses;
}
