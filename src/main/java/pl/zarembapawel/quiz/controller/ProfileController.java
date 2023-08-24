package pl.zarembapawel.quiz.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.zarembapawel.quiz.model.Profile;
import pl.zarembapawel.quiz.service.ProfileService;

@RestController
@RequestMapping("/quiz/profile")
@AllArgsConstructor
public class ProfileController {

    private ProfileService service;

    @GetMapping("/{name}")
    public Profile getByName(@PathVariable String name) {
        Profile profile = service.get(name);
        if (profile == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return profile;
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody Profile profile) {
        HttpStatus status = service.add(profile);
        return new ResponseEntity<>(status);
    }

    @PutMapping("/updateProfilePoints/{name}/{points}")
    public ResponseEntity<Void> updateProfilePoints(@PathVariable String name,
                                                    @PathVariable Integer points) {
        HttpStatus status = service.updateProfilePoints(name, points);
        return new ResponseEntity<>(status);
    }
}
