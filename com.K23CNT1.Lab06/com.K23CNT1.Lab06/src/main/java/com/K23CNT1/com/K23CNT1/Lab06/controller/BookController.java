package com.K23CNT1.com.K23CNT1.Lab06.controller; // ĐÃ SỬA: Thêm phần bị lặp

// ĐÃ SỬA CÁC DÒNG IMPORT DƯỚI ĐÂY:
import com.K23CNT1.com.K23CNT1.Lab06.entity.Book;
import com.K23CNT1.com.K23CNT1.Lab06.entity.Author;
import com.K23CNT1.com.K23CNT1.Lab06.service.BookService;
import com.K23CNT1.com.K23CNT1.Lab06.repository.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorRepository authorRepository;

    // 1. Hiển thị danh sách sách
    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "book-list";
    }

    // 2. Hiển thị form thêm mới
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorRepository.findAll());
        return "book-form";
    }

    // 3. Hiển thị form sửa
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Book book = bookService.getById(id);
        if (book != null) {
            model.addAttribute("book", book);
            model.addAttribute("authors", authorRepository.findAll());
            return "book-form";
        }
        return "redirect:/books";
    }

    // 4. Lưu sách + upload ảnh
    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book,
                           @RequestParam(value = "fileImage", required = false) MultipartFile file) {
        try {
            if (file != null && !file.isEmpty() && file.getOriginalFilename() != null) {
                String projectDir = System.getProperty("user.dir");
                Path uploadPath = Paths.get(projectDir, "src/main/resources/static/images");

                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                String fileName = file.getOriginalFilename();
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                book.setImage("/images/" + fileName);
            }
            // Gọi service save
            bookService.save(book);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/books";
    }

    // 5. Xóa sách
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Integer id) {
        bookService.delete(id);
        return "redirect:/books";
    }
}