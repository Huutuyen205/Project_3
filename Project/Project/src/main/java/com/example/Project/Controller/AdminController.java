package com.example.Project.Controller;

import com.example.Project.entity.Comic;
import com.example.Project.repository.OrderRepository;
import com.example.Project.security.Admin;
import com.example.Project.service.AdminService;
import com.example.Project.service.ComicService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.InputStream;
import java.nio.file.*;

@Controller
public class AdminController implements WebMvcConfigurer {

    @Autowired private AdminService adminService;
    @Autowired private ComicService comicService;
    @Autowired private OrderRepository orderRepository;

    // Cấu hình đường dẫn ảnh
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Path uploadDir = Paths.get("./src/main/resources/static/images/");
        String uploadPath = uploadDir.toFile().getAbsolutePath();
        registry.addResourceHandler("/images/**").addResourceLocations("file:/" + uploadPath + "/");
    }

    // --- ĐĂNG NHẬP ---
    @GetMapping("/admin/login")
    public String loginPage() { return "login"; }

    @PostMapping("/admin/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        Admin admin = adminService.login(username, password);
        if (admin != null) {
            session.setAttribute("admin", admin);
            return "redirect:/admin/home";
        }
        return "redirect:/admin/login?error";
    }

    @GetMapping("/admin/home")
    public String dashboard(HttpSession session) {
        if (session.getAttribute("admin") == null) return "redirect:/admin/login";
        return "admin-home";
    }

    // --- DANH SÁCH TRUYỆN (Đã sửa khớp với SQL) ---
    @GetMapping("/admin/comics")
    public String list(Model model, HttpSession session) {
        if (session.getAttribute("admin") == null) return "redirect:/admin/login";

        // Tìm đúng tên như trong SQL (conan, doraemon, ngu-ngon...)
        model.addAttribute("listConan", comicService.getByCategory("conan"));
        model.addAttribute("listDoraemon", comicService.getByCategory("doraemon"));
        model.addAttribute("listNguNgon", comicService.getByCategory("ngu-ngon"));
        model.addAttribute("listCoTich", comicService.getByCategory("co-tich"));
        model.addAttribute("listNuocNgoai", comicService.getByCategory("nuoc-ngoai"));

        return "comic-list";
    }

    // --- THÊM MỚI ---
    @GetMapping("/admin/comic/add")
    public String addForm(Model model, HttpSession session) {
        if (session.getAttribute("admin") == null) return "redirect:/admin/login";
        model.addAttribute("comic", new Comic());
        return "comic-form";
    }

    // --- LƯU ---
    @PostMapping("/admin/comic/save")
    public String save(@ModelAttribute Comic comic, @RequestParam("imageFile") MultipartFile imageFile) {
        if (!imageFile.isEmpty()) {
            try {
                String fileName = imageFile.getOriginalFilename();
                Path uploadPath = Paths.get("src/main/resources/static/images/");
                if (!Files.exists(uploadPath)) Files.createDirectories(uploadPath);
                try (InputStream inputStream = imageFile.getInputStream()) {
                    Files.copy(inputStream, uploadPath.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
                }
                comic.setImageUrl(fileName);
            } catch (Exception e) { e.printStackTrace(); }
        }
        comicService.save(comic);
        return "redirect:/admin/comics";
    }

    // --- XÓA ---
    @GetMapping("/admin/comic/delete/{id}")
    public String delete(@PathVariable Long id, HttpSession session) {
        if (session.getAttribute("admin") == null) return "redirect:/admin/login";
        comicService.delete(id);
        return "redirect:/admin/comics";
    }

    // --- ĐƠN HÀNG ---
    @GetMapping("/admin/orders")
    public String listOrders(Model model, HttpSession session) {
        if (session.getAttribute("admin") == null) return "redirect:/admin/login";
        model.addAttribute("orders", orderRepository.findAll());
        return "order-list";
    }
}