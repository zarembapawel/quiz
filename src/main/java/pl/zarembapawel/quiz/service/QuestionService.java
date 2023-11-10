package pl.zarembapawel.quiz.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.zarembapawel.quiz.entity.QuestionEntity;
import pl.zarembapawel.quiz.model.Question;
import pl.zarembapawel.quiz.repository.QuestionRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class QuestionService {

    private QuestionRepository repository;

    private ModelMapper mapper;

    public Question getQuestionById(String id) {
        Optional<QuestionEntity> questionEntity = repository.findById(id);
        return questionEntity.map(entity -> mapper.map(entity, Question.class)).orElse(null);
    }

    public void addQuestion(Question question) {
        log.info("Adding question: {}", question);
        QuestionEntity entity = mapper.map(question, QuestionEntity.class);
        repository.save(entity);
    }

    public void disableQuestion(String id) {
        Optional<QuestionEntity> question = repository.findById(id);
        if (question.isPresent()) {
            log.info("Disable question: {}", id);
            question.get().setIsActive(false);
            question.get().setDateUpdate(LocalDateTime.now());
            repository.save(question.get());
        }
    }
}
