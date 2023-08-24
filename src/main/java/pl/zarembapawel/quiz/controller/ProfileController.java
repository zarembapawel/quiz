package pl.zarembapawel.quiz.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zarembapawel.quiz.model.Profile;
import pl.zarembapawel.quiz.service.ProfileService;

@RestController
@RequestMapping("/quiz/profile")
@AllArgsConstructor
public class ProfileController {

    private ProfileService service;

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody Profile profile) {
        HttpStatus status = service.add(profile);
        return new ResponseEntity<>(status);
    }
}
