package com.example.demo.model;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

@Data
public class Article implements Serializable {
    String author;
    String title;
    String description;
    String url;
    String content;
    LocalDateTime publishedAt;
    Map<Boolean, String> sourceMap;
    String urlToImage;

}
