package com.example.demo.controller;

import com.example.demo.model.Article;
import com.example.demo.model.Articles;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class ExternalApi {

    @GetMapping("/articles")
    public String articles(Model model){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
        httpHeaders.add("X-Api-Key", "L+yYBfrZsqO/6RfMqGgNdQ==C9F4avSony9kQcWn");
        String url = "https://api.api-ninjas.com/v1/facts?limit=10";
        HttpEntity<List<String>> http = new HttpEntity<List<String>>(httpHeaders);
        List res = restTemplate.exchange(url,HttpMethod.GET, http, List.class).getBody();
        model.addAttribute("api", res);
        return "articles";
    }

    @GetMapping("/stats")
    public String stats(Model model){
        return "stat";
    }

    @GetMapping("/stats/search")
    public String search(Model model, @RequestParam(name = "keyword", required = false) String keyword){
        if  (keyword != null){
            RestTemplate restTemplate =new RestTemplate();
            String url = "https://newsapi.org/v2/everything?q="+keyword+"&apiKey=bf881ce7a61b4117be1964945e2fd094";
            ResponseEntity<Articles> entity = restTemplate.getForEntity(url, Articles.class);
            Articles articles = entity.getBody();
            assert articles != null;
            model.addAttribute("stats", articles);

        }
        return "stats";
    }
}
