package com.example.Project.Controller;

import com.example.Project.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ComicController {
    @Autowired private ComicService comicService;

    @GetMapping("/")
    public String showStoreHome(Model model) {
        model.addAttribute("comics", comicService.getAll());
        return "store-home";
    }
}