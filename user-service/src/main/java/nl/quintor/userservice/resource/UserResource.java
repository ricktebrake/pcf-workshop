package nl.quintor.userservice.resource;

import nl.quintor.userservice.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserResource {


    @GetMapping
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(UUID.randomUUID(), "gentlehartebeest"));
        users.add(new User(UUID.randomUUID(), "yachtchicken"));
        return users;
    }

}
