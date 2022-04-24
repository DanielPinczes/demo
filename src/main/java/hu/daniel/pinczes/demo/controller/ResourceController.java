package hu.daniel.pinczes.demo.controller;

import hu.daniel.pinczes.demo.service.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/resources")
@RequiredArgsConstructor
public class ResourceController {

    private final ResourceService service;

    @GetMapping("/books")
    public ResponseEntity<String> getBooks() {
        String books = service.getBooksReadableForm();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/urls")
    public ResponseEntity<String> getUrls() {
        String urls = service.getURLsReadableForm();
        return ResponseEntity.ok(urls);
    }
}
