package nl.quintor.userservice.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/healthcheck")
public class HealthResource {

    @GetMapping
    public ResponseEntity healthCheck() {
        return ResponseEntity.ok().build();
    }
}
