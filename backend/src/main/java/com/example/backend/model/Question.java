package com.example.backend.model;

import java.util.List;

public record Question(Long id, String text, List<String> options) {
}