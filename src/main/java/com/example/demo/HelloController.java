package com.example.demo;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    private final NoteRepository noteRepository;

    public HelloController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello, Spring Boot!";
    }

    @PostMapping("/greet")
    public String greet(@Valid @RequestBody GreetingRequest request) {
        return "Hello, " + request.getName() + "!";
    }

    @GetMapping("/notes")
    public List<Note> notes() {
        return noteRepository.findAll();
    }

    @PostMapping("/notes")
    public Note createNote(@RequestBody Note note) {
        return noteRepository.save(note);
    }
}