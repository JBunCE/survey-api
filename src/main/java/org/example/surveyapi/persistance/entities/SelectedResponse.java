package org.example.surveyapi.persistance.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.example.surveyapi.persistance.enums.Index;

@Entity
@Getter @Setter
@Table(name = "selected_responses")
public class SelectedResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long selectedResponseId;

    @Enumerated(value = EnumType.STRING)
    private Index index;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "response_id", nullable = false)
    private Response response;

}
