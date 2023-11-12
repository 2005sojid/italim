package com.example.demo.controller;

import com.example.demo.model.Tag;
import com.example.demo.repo.TagRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TagController {
    private final TagRepo tagRepo;

    public TagController(TagRepo tagRepo) {
        this.tagRepo = tagRepo;
    }

    @RequestMapping(path = {"/tags"})
    public String tags(Model model, @RequestParam(name = "keyword", required = false) String keyword){
//        model.addAttribute("tags", tagRepo.findAll());
        return "tag";
    }

    @RequestMapping(path = {"/tags/search"})
    public String searchTags(Model model, @RequestParam(name = "keyword", required = false) String keyword){
        if (keyword != null){
            List<Tag> tags = tagRepo.findTagsByNameContainingIgnoreCase(keyword);
            model.addAttribute("tags", tags);
        }
        return "tags";
    }

    @RequestMapping(path = {"/biology"})
    public String biology(Model model, @RequestParam(name = "keyword", required = false) String keyword, @RequestParam(name = "parent", defaultValue = "биология") String parent){
        if (keyword != null){
            List<Tag> tags = tagRepo.findTagsByNameContainingIgnoreCase(keyword);
            model.addAttribute("tags", tags);
        }
        else{

            model.addAttribute("tags", tagRepo.findTagsByParentContainingIgnoreCase(parent));


        }

        return "biology";
    }
    @RequestMapping(path = {"/medicine"})
    public String medicine(Model model, @RequestParam(name = "keyword", required = false) String keyword, @RequestParam(name = "parent", defaultValue = "медицина") String parent){
        if (keyword != null){
            List<Tag> tags = tagRepo.findTagsByNameContainingIgnoreCase(keyword);
            model.addAttribute("tags", tags);
        }
        else{

            model.addAttribute("tags", tagRepo.findTagsByParentContainingIgnoreCase(parent));


        }

        return "medicine";
    }

    @GetMapping("/physics")
    public String physics(){
        return "physics";
    }



}
