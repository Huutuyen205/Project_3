package com.example.K23CNT1.NhtDay03.controller;

import com.example.K23CNT1.NhtDay03.entity.NhtStudent;
import com.example.K23CNT1.NhtDay03.service.NhtServiceStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students") // URL gốc
public class NhtStudentController {

    @Autowired
    private NhtServiceStudent studentService;

    // 👉 Lấy tất cả sinh viên
    @GetMapping("/all")
    public ResponseEntity<List<NhtStudent>> getAllStudents() {
        List<NhtStudent> students = studentService.getStudents();
        if (students.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(students);
    }

    // 👉 Lấy sinh viên theo ID
    @GetMapping("/detail/{id}")
    public ResponseEntity<NhtStudent> getStudentById(@PathVariable Long id) {
        NhtStudent student = studentService.getStudent(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // 👉 Thêm sinh viên mới
    @PostMapping("/add")
    public ResponseEntity<NhtStudent> addStudent(@RequestBody NhtStudent student) {
        try {
            NhtStudent savedStudent = studentService.addStudent(student);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // 👉 Cập nhật sinh viên
    @PutMapping("/update/{id}")
    public ResponseEntity<NhtStudent> updateStudent(@PathVariable Long id, @RequestBody NhtStudent student) {
        NhtStudent updatedStudent = studentService.updateStudent(id, student);
        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // 👉 Xóa sinh viên
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        boolean deleted = studentService.deleteStudent(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
