package warehouse.inneroperationscore.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartController {

    @GetMapping("/")
    public ResponseEntity<String> homePage() {
        return ResponseEntity.ok("home page");
    }
}
