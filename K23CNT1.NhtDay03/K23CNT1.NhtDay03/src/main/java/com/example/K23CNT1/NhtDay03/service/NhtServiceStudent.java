package com.example.K23CNT1.NhtDay03.service;

import com.example.K23CNT1.NhtDay03.entity.NhtStudent;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class NhtServiceStudent {

    private List<NhtStudent> students = new ArrayList<>();

    public NhtServiceStudent() {
        students.addAll(Arrays.asList(
                new NhtStudent(1L, "Nguyen Van A", 20, "Nam", "Ha Noi", "0901234567", "a@gmail.com"),
                new NhtStudent(2L, "Tran Thi B", 21, "Nu", "Da Nang", "0907654321", "b@gmail.com"),
                new NhtStudent(3L, "Le Van C", 22, "Nam", "TP.HCM", "0988888888", "c@gmail.com"),
                new NhtStudent(4L, "Nguyen Huu Tuyen", 20, "Nam", "Vinh Phuc", "0941033632", "huutuyen123tc@gmail.com")
        ));
    }

    // Lấy toàn bộ danh sách sinh viên
    public List<NhtStudent> getStudents() {
        return students;
    }

    // Lấy sinh viên theo ID
    public NhtStudent getStudent(Long id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Thêm sinh viên mới
    public NhtStudent addStudent(NhtStudent student) {
        students.add(student);
        return student;
    }

    // Cập nhật thông tin sinh viên
    public NhtStudent updateStudent(Long id, NhtStudent student) {
        NhtStudent existing = getStudent(id);
        if (existing == null) {
            return null;
        }

        existing.setName(student.getName());
        existing.setAge(student.getAge());
        existing.setGender(student.getGender());
        existing.setAddress(student.getAddress());
        existing.setPhone(student.getPhone());
        existing.setEmail(student.getEmail());

        return existing;
    }

    // Xóa sinh viên
    public boolean deleteStudent(Long id) {
        NhtStudent existing = getStudent(id);
        if (existing == null) {
            return false;
        }
        return students.remove(existing);
    }
}
