package com.K23CNT.K23CNT.lesson07.repository;
import com.K23CNT.K23CNT.lesson07.entity.category;
import
        org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoryRepository extends
        JpaRepository<category, Long> {
}
