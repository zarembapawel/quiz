package pl.zarembapawel.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zarembapawel.quiz.entity.AnswerEntity;

public interface AnswerRepository extends JpaRepository<AnswerEntity, String> {
}
