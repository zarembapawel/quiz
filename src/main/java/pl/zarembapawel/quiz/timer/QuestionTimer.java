package pl.zarembapawel.quiz.timer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.zarembapawel.quiz.model.Question;
import pl.zarembapawel.quiz.model.TriviaQuestion;
import pl.zarembapawel.quiz.service.QuestionService;

@AllArgsConstructor
@Slf4j
public class QuestionTimer {

    private QuestionService service;

    public void getQuestionsFromTrivia() {
        TriviaQuestion triviaQuestion = new TriviaQuestion();
        Question question = new Question();
        service.addQuestion(question);
    }
}
