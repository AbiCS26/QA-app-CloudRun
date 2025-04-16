package com.example.backend.service;

import org.springframework.stereotype.Service;

import com.example.backend.model.Question;
import com.example.backend.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuizService {
    private final Map<String, User> users = new HashMap<>();
    private final Map<Long, Question> questions = new HashMap<>();

    public QuizService() {
        // Add dummy questions
        questions.put(1L, new Question(1L, "What is 2 + 2?", List.of("3", "4", "5")));
        questions.put(2L, new Question(2L, "What is the capital of France?", List.of("Berlin", "Madrid", "Paris")));
        questions.put(3L, new Question(3L, "What is the largest ocean?", List.of("Atlantic", "Indian", "Pacific")));
        questions.put(4L, new Question(4L, "What is the smallest prime number?", List.of("0", "1", "2")));
        questions.put(5L, new Question(5L, "What is the chemical symbol for gold?", List.of("Au", "Ag", "Pb")));
        // Add a dummy user
        users.put("testuser", new User("testuser", "password"));
    }

    public boolean authenticateUser(String username, String password) {
        User user = users.get(username);
        return user != null && user.password().equals(password);
    }

    public List<Question> getQuestions() {
        return new ArrayList<>(questions.values());
    }

    public int submitAnswers(Map<Long, String> answers) {
        int score = 0;
        if (answers.get(1L).equals("4"))
            score++;
        if (answers.get(2L).equals("Paris"))
            score++;
        if (answers.get(3L).equals("Pacific"))
            score++;
        if (answers.get(4L).equals("2"))
            score++;
        if (answers.get(5L).equals("Au"))
            score++;
        return score;
    }
}
