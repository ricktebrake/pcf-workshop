package nl.quintor.userservice.domain;

import java.util.UUID;

public class User {

    private UUID id;
    private String username;

    public User(UUID id, String username) {
        this.id = id;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public UUID getId() {
        return id;
    }
}
