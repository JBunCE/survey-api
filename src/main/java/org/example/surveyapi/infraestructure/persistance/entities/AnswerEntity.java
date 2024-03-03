package org.example.surveyapi.infraestructure.persistance.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.example.surveyapi.domain.models.value.objects.Index;

@Entity
@Table(name = "answers")
@Getter @Setter
public class AnswerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Integer points;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Index index;

    @OneToOne(mappedBy = "answer")
    @JoinColumn(name = "tag", nullable = false)
    private TagEntity tagEntity;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private QuestionEntity questionEntity;
}
