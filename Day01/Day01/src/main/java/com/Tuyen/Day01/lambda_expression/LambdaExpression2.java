package com.Tuyen.Day01.lambda_expression;

@FunctionalInterface
interface SayHello2 {
    public void sayHello(String name);
}

public class LambdaExpression2 {
    public static void main(String[] args) {
        // Lambda sử dụng 1 tham số (có kiểu dữ liệu rõ ràng)
        SayHello2 say1 = (name) -> {
            System.out.println("Hello " + name);
        };
        say1.sayHello("Devmaster");

        // Ngắn gọn (bỏ ngoặc đơn cho tham số)
        SayHello2 say2 = name -> {
            System.out.println("Hello " + name);
        };
        say2.sayHello("Devmaster");

        // Ngắn gọn hơn (bỏ ngoặc nhọn {} và từ khóa return nếu là biểu thức đơn)
        SayHello2 say3 = name -> System.out.println("Hello " + name);
        say3.sayHello("Devmaster");
    }
}