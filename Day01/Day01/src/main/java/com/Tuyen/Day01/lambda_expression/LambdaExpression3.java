package com.Tuyen.Day01.lambda_expression;

@FunctionalInterface
interface Calculator1 {
    int add(int a, int b);
}

@FunctionalInterface
interface Calculator2 {
    void add(int a, int b);
}

public class LambdaExpression3 {
    public static void main(String[] args) {
        // Calculator1: Trả về giá trị (int)
        // Dùng kiểu dữ liệu tường minh (int a, int b)
        Calculator1 calc1 = (int a, int b) -> (a + b);
        System.out.println(calc1.add(11, 12)); // Output: 23

        // Calculator1: Trả về giá trị (int)
        // Ngắn gọn: Bỏ kiểu dữ liệu của tham số và ngoặc đơn cho biểu thức đơn
        Calculator1 calc2 = (a, b) -> (a + b);
        System.out.println(calc2.add(21, 22)); // Output: 43

        // Calculator2: Không trả về giá trị (void)
        // Ngắn gọn: Bỏ ngoặc nhọn {} và thực hiện lệnh trực tiếp
        Calculator2 calc3 = (a, b) ->
                System.out.println(a + b);
        calc3.add(31, 32); // Output: 63

        // Calculator2: Không trả về giá trị (void)
        // Dùng ngoặc nhọn {} vì có nhiều hơn một câu lệnh hoặc khai báo biến
        Calculator2 calc4 = (a, b) -> {
            int sum = a + b;
            System.out.println(a + "+" + b + "=" + sum);
        };
        calc4.add(41, 42); // Output: 41+42=83
    }
}