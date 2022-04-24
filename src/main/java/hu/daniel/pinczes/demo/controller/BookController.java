package hu.daniel.pinczes.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/resources")
@RequiredArgsConstructor
public class BookController {

    @Value("${show.author}")
    private Boolean showAuthor;

    @GetMapping("/books")
    public ResponseEntity<String> getContract() {
        return showAuthor
                ? ResponseEntity.ok("Author + BOOKS")
                : ResponseEntity.ok("BOOKS");
    }
}
