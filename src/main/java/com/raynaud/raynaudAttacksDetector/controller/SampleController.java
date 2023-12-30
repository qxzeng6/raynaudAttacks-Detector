package com.raynaud.raynaudAttacksDetector.controller;

import com.raynaud.raynaudAttacksDetector.model.Content;
import com.raynaud.raynaudAttacksDetector.repository.ContentCollectionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
@CrossOrigin(origins = "http://localhost:8080")
public class SampleController {

    private final ContentCollectionRepository repository;
    public SampleController(ContentCollectionRepository repository) {
        this.repository = repository;


    }
    @GetMapping("")
    public List<Content> getContentCollection() {
        System.out.println("Access here! " );
        return repository.getContentCollection();

    }
    @GetMapping("/{id}")
    public Content getContentById(@PathVariable Integer id) {
        System.out.println("id = " + id);
        return repository.getContentById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void createContent(@RequestBody Content content) {
        System.out.println("content = " + content);
        repository.save(content);
    }
}
