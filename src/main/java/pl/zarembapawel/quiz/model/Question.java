package pl.zarembapawel.quiz.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Question {

    private String id;
    private String category;
    private String question;
    private String answers;
    private String correctAnswer;
    private String difficulty;
    private LocalDateTime dateAdd;
    private LocalDateTime dateUpdate;
    private Boolean isActive;
}
