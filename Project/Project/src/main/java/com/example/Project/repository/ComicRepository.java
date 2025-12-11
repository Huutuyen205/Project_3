package com.example.Project.repository;

import com.example.Project.entity.Comic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ComicRepository extends JpaRepository<Comic, Long> {

    // 1. Tìm kiếm theo tên (cho chức năng Search)
    List<Comic> findByTitleContainingIgnoreCase(String keyword);

    // 2. Tìm kiếm theo thể loại (cho chức năng Menu Filter)
    List<Comic> findByCategory(String category);
}