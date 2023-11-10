package pl.zarembapawel.quiz.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.zarembapawel.quiz.entity.AnswerEntity;
import pl.zarembapawel.quiz.model.Profile;
import pl.zarembapawel.quiz.model.Question;
import pl.zarembapawel.quiz.repository.AnswerRepository;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class AnswerService {

    private AnswerRepository repository;

    private QuestionService questionService;

    private ProfileService profileService;

    private Boolean addAnswer(String questionId, Integer profileId, String userAnswer) {
        Question question = questionService.getQuestionById(questionId);

        if (question == null) {
            throw new RuntimeException("Question not found!");
        }

        boolean isCorrect = question.getCorrectAnswer().equals(userAnswer);
        int points = (isCorrect) ? 1 : -1;

        AnswerEntity answer = new AnswerEntity();
        answer.setQuestionId(questionId);
        answer.setProfileId(profileId);
        answer.setIsCorrect(isCorrect);
        answer.setDate(LocalDateTime.now());
        log.info("Adding answer: {}", answer);
        repository.save(answer);

        Profile profile = profileService.get(profileId);
        profileService.updateProfilePoints(profile.getName(), points);

        return isCorrect;
    }
}
