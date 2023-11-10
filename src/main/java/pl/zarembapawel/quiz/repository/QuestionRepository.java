package pl.zarembapawel.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zarembapawel.quiz.entity.QuestionEntity;

public interface QuestionRepository extends JpaRepository<QuestionEntity, String> {
}
