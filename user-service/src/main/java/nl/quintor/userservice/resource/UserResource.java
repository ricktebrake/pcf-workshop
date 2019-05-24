package nl.quintor.userservice.resource;

import nl.quintor.userservice.domain.User;
import nl.quintor.userservice.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserResource {

    Logger logger = LoggerFactory.getLogger(UserResource.class);


    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public Iterable<User> getUsers() {
        logger.info("All users requested");

        return userRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> findUser(@PathVariable("id") UUID id) {

        logger.info("User requested with id: " + id.toString());

        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = "application/json")
    public User insertUser(@RequestBody User user) {
        User result = userRepository.save(new User(UUID.randomUUID(), user.getUsername()));
        logger.info("New user created with id: " + user.getId().toString());
        return result;
    }
}
