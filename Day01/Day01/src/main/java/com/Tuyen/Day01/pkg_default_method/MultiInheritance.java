package com.Tuyen.Day01.pkg_default_method;

interface Interface1 {
    default void method1() {
        System.out.println("Interface1.method1");
    }
}

interface Interface2 {
    default void method2() {
        System.out.println("Interface2.method2");
    }
}

public class MultiInheritance implements Interface1, Interface2 {
    @Override
    public void method1() {
        // Ghi đè method1 nhưng vẫn gọi triển khai mặc định của Interface1
        Interface1.super.method1();
    }

    @Override
    public void method2() {
        // Ghi đè hoàn toàn method2, cung cấp triển khai riêng
        System.out.println("MultiInheritance.method2");
    }

    public static void main(String[] args) {
        MultiInheritance obj = new MultiInheritance();
        obj.method1();
        obj.method2();
    }
}