package pl.zarembapawel.quiz.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Table(name = "answers")
public class AnswerEntity {

    @Column(name = "question_id")
    private String questionId;

    @Column(name = "profile_id")
    private Integer profileId;

    @Column(name = "is_correct")
    private Boolean isCorrect;

    @Column(name = "date")
    private LocalDateTime date;
}
