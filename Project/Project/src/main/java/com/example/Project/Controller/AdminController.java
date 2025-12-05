package com.example.Project.Controller;

import com.example.Project.entity.Comic;
import com.example.Project.security.Admin;
import com.example.Project.service.AdminService;
import com.example.Project.service.ComicService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired private AdminService adminService;
    @Autowired private ComicService comicService;

    @GetMapping("/login")
    public String loginPage() { return "login"; }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        Admin admin = adminService.login(username, password);
        if (admin != null) {
            session.setAttribute("admin", admin);
            return "redirect:/admin/home";
        }
        return "redirect:/admin/login?error";
    }

    @GetMapping("/home")
    public String dashboard(HttpSession session) {
        return (session.getAttribute("admin") == null) ? "redirect:/admin/login" : "admin-home";
    }

    @GetMapping("/comics")
    public String list(Model model, HttpSession session) {
        if (session.getAttribute("admin") == null) return "redirect:/admin/login";
        model.addAttribute("comics", comicService.getAll());
        return "comic-list";
    }

    @GetMapping("/comic/add")
    public String addForm(HttpSession session) {
        return (session.getAttribute("admin") == null) ? "redirect:/admin/login" : "comic-form";
    }

    @PostMapping("/comic/save")
    public String save(@ModelAttribute Comic comic) {
        comicService.save(comic);
        return "redirect:/admin/comics";
    }

    @GetMapping("/comic/delete/{id}")
    public String delete(@PathVariable Long id) {
        comicService.delete(id);
        return "redirect:/admin/comics";
    }
}