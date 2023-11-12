package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class Articles {
    String status;
    int totalResults;
    List<Article> articles;
}
