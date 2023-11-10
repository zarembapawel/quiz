package pl.zarembapawel.quiz.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class TriviaQuestion {

    private String id;
    private String category;
    private String correctAnswer;
    private List<String> incorrectAnswers;
    private QuestionText question;
    private String difficulty;


    @Getter
    @Setter
    @ToString
    private static class QuestionText {
        private String text;
    }
}
