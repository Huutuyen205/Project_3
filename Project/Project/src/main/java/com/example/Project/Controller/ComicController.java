package com.example.Project.Controller;

import com.example.Project.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ComicController {

    @Autowired private ComicService comicService;

    @GetMapping("/")
    public String showStoreHome(Model model) {
        // Lấy dữ liệu theo ĐÚNG tên trong file SQL của bạn (không dấu, gạch ngang)
        model.addAttribute("listConan", comicService.getByCategory("conan"));
        model.addAttribute("listDoraemon", comicService.getByCategory("doraemon"));
        model.addAttribute("listNguNgon", comicService.getByCategory("ngu-ngon"));
        model.addAttribute("listCoTich", comicService.getByCategory("co-tich"));
        model.addAttribute("listNuocNgoai", comicService.getByCategory("nuoc-ngoai"));

        model.addAttribute("isSearching", false);
        model.addAttribute("keyword", "");
        return "store-home";
    }

    @GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword, Model model) {
        model.addAttribute("searchResults", comicService.searchComics(keyword));
        model.addAttribute("isSearching", true);
        model.addAttribute("keyword", keyword);
        return "store-home";
    }
}