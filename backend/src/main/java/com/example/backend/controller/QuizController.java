package com.example.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backend.model.Question;
import com.example.backend.service.QuizService;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Map<String, String> loginDetails) {
        System.out.println("Login details: " + loginDetails);
        String username = loginDetails.get("username");
        String password = loginDetails.get("password");
        if (quizService.authenticateUser(username, password)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    @GetMapping("/questions")
    public List<Question> getQuestions() {
        return quizService.getQuestions();
    }

    @PostMapping("/submit")
    public Map<String, Integer> submitAnswers(@RequestBody Map<Long, String> answers) {
        int score = quizService.submitAnswers(answers);
        return Map.of("score", score);
    }
}
