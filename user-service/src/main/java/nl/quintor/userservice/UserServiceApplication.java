package nl.quintor.userservice;

import nl.quintor.userservice.domain.User;
import nl.quintor.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

@SpringBootApplication
public class UserServiceApplication implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }


    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        userRepository.save(new User(UUID.randomUUID(), "gentlehartebeest"));
        userRepository.save(new User(UUID.randomUUID(), "yachtchicken"));
        userRepository.save(new User(UUID.randomUUID(), "butteredgibbon"));
    }
}
