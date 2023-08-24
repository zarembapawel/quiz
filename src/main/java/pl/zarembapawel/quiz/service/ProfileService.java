package pl.zarembapawel.quiz.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pl.zarembapawel.quiz.entity.ProfileEntity;
import pl.zarembapawel.quiz.model.Profile;
import pl.zarembapawel.quiz.repository.ProfileRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ProfileService {

    private ProfileRepository repository;

    private ModelMapper mapper;

    public HttpStatus add(Profile profile) {
        log.info("Adding profile: {}", profile);
        if (get(profile.getName()) != null) {
            log.error("Profile already exist");
            return HttpStatus.CONFLICT;
        }
        profile.setPoints(0);
        repository.save(mapper.map(profile, ProfileEntity.class));
        log.info("Profile has been added");
        return HttpStatus.CREATED;
    }

    public Profile get(String name) {
        Optional<ProfileEntity> entity = repository.findByName(name);
        return entity.map(profileEntity -> mapper.map(profileEntity, Profile.class))
                     .orElse(null);
    }

    public HttpStatus updateProfilePoints(String name, Integer points) {
        log.info("Updating profile {} points {}", name, points);
        Profile profile = get(name);
        if (profile == null) {
            log.error("Profile don't exist");
            return HttpStatus.NOT_FOUND;
        }
        log.info("Points before update {}", profile.getPoints());
        profile.setPoints(profile.getPoints() + points);
        log.info("Points after update {}", profile.getPoints());
        repository.save(mapper.map(profile, ProfileEntity.class));
        return HttpStatus.NO_CONTENT;
    }
}
