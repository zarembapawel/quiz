package pl.zarembapawel.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zarembapawel.quiz.entity.ProfileEntity;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Integer> {

    Optional<ProfileEntity> findByName(String name);
}
