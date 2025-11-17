package com.K23CNT.K23CNT.lesson07.Controller;

import com.K23CNT.K23CNT.lesson07.entity.category;
import com.K23CNT.K23CNT.lesson07.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "category/category-list"; // Trỏ tới templates/category/category-list.html
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("category", new category());
        return "category/category-form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("category",
                categoryService.getCategoryById(id).orElse(null));
        return "category/category-form";
    }

    // === PHẦN SỬA LỖI/ĐƠN GIẢN HÓA ===
    /**
     * Dùng 1 hàm "save" duy nhất cho cả Create và Update.
     * Form HTML sẽ post đến "/category/save".
     */
    @PostMapping("/save")
    public String saveCategory(@ModelAttribute("category") category category) {
        // Đối tượng 'category' này đã chứa ID (nếu là edit)
        // hoặc có ID = null (nếu là create) lấy từ form.
        //
        // Bạn không cần dòng 'category.setId(id)' nữa.

        categoryService.saveCategory(category);
        return "redirect:/category";
    }
    // === KẾT THÚC PHẦN SỬA ===


    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/category";
    }
}