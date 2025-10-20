package com.Tuyen.Day01.method_ref;

import java.util.Arrays;

// Interface Function (Functional Interface)
@FunctionalInterface
interface ExecuteFunction {
    public int execute(int a, int b);
}

// Class chứa các phương thức tĩnh và phương thức thể hiện
class MathUtils {
    public MathUtils() {}

    public MathUtils(String str) {
        System.out.println("MathUtils:" + str);
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int minus(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DemoMethodRef {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        // 1. Tham chiếu đến một phương thức tĩnh (Static Method Reference)
        int sum = doAction(a, b, MathUtils::sum);
        System.out.println(a + " + " + b + " = " + sum);

        int minus = doAction(a, b, MathUtils::minus);
        System.out.println(a + " - " + b + " = " + minus);

        // 2. Tham chiếu đến một phương thức thể hiện (Instance Method Reference)
        // của một đối tượng cụ thể (specific object)
        MathUtils mathUtils = new MathUtils();
        int multiply = doAction(a, b, mathUtils::multiply);
        System.out.println(a + " * " + b + " = " + multiply);

        // 3. Tham chiếu đến một instance method của một đối tượng tùy ý
        // của một kiểu cụ thể (Arbitrary Object of a particular Type)
        String[] stringArray = {"Java", "C++", "PHP", "C#", "Javascript"};

        // String::compareToIgnoreCase tương đương với (s1, s2) -> s1.compareToIgnoreCase(s2)
        Arrays.sort(stringArray, String::compareToIgnoreCase);

        for (String str : stringArray) {
            System.out.println(str);
        }
    }

    public static int doAction(int a, int b, ExecuteFunction func) {
        return func.execute(a, b);
    }
}