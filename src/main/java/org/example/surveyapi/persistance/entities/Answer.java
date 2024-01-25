package org.example.surveyapi.persistance.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.example.surveyapi.persistance.enums.Index;

import java.util.Set;

@Entity
@Table(name = "answers")
@Getter @Setter
public class Answer {

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
    private Tag tag;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;
}
