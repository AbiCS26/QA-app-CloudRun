package com.example.backend.service;

import org.springframework.stereotype.Service;

import com.example.backend.model.Question;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class QuestionService {
    private final List<Question> questions = List.of(
            new Question(1, "What is the capital of France?", Arrays.asList("Paris", "London", "Rome"), "Paris"),
            new Question(2, "Which planet is known as the Red Planet?", Arrays.asList("Mars", "Venus", "Jupiter"),
                    "Mars"),
            new Question(3, "What is 2 + 2?", Arrays.asList("3", "4", "5"), "4"));

    public List<Question> getQuestions() {
        return questions;
    }

    public int calculateScore(Map<Integer, String> answers) {
        return (int) questions.stream()
                .filter(q -> answers.containsKey(q.getId()) && q.getCorrectAnswer().equals(answers.get(q.getId())))
                .count();
    }
}
