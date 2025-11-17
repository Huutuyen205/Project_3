package com.K23CNT.K23CNT.lesson07.Service;

import com.K23CNT.K23CNT.lesson07.entity.category;
import com.K23CNT.K23CNT.lesson07.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Đánh dấu đây là một lớp Service
public class CategoryService {

    // Tiêm CategoryRepository để làm việc với CSDL
    @Autowired
    private CategoryRepository categoryRepository;

    // Phương thức lấy tất cả danh mục
    public List<category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Phương thức tìm danh mục theo ID
    public Optional<category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    // Phương thức lưu (thêm mới hoặc cập nhật) một danh mục
    public category saveCategory(category category) {
        return categoryRepository.save(category);
    }

    // Phương thức xóa danh mục theo ID
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}