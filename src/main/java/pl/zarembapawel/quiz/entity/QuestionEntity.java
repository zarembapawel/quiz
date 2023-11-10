package pl.zarembapawel.quiz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "questions")
public class QuestionEntity {

    @Column(name = "id")
    private String id;

    @Column(name = "category")
    private String category;

    @Column(name = "question")
    private String question;

    @Column(name = "answers")
    private String answers;

    @Column(name = "correct_answer")
    private String correctAnswer;

    @Column(name = "difficulty")
    private String difficulty;

    @Column(name = "date_add")
    private LocalDateTime dateAdd;

    @Column(name = "date_update")
    private LocalDateTime dateUpdate;

    @Column(name = "is_active")
    private Boolean isActive;
}
