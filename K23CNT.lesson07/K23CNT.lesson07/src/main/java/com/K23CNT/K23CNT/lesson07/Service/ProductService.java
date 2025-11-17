package com.K23CNT.K23CNT.lesson07.Service;

import com.K23CNT.K23CNT.lesson07.entity.product;
import com.K23CNT.K23CNT.lesson07.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Đánh dấu đây là một lớp Service
public class ProductService {

    // Tiêm ProductRepository để làm việc với CSDL
    @Autowired
    private ProductRepository productRepository;

    // Phương thức lấy tất cả sản phẩm
    public List<product> getAllProducts() {
        return productRepository.findAll();
    }

    // Phương thức tìm sản phẩm theo ID
    public Optional<product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Phương thức lưu (thêm mới hoặc cập nhật) một sản phẩm
    public product saveProduct(product product) {
        return productRepository.save(product);
    }

    // Phương thức xóa sản phẩm theo ID
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}