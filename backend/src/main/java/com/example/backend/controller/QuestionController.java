package com.example.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.backend.model.Question;
import com.example.backend.service.QuestionService;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/questions")
    public List<Question> getQuestions() {
        return questionService.getQuestions();
    }

    @PostMapping("/submit")
    public Map<String, Integer> submitAnswers(@RequestBody Map<Integer, String> answers) {
        int score = questionService.calculateScore(answers);
        return Map.of("score", score);
    }
}
