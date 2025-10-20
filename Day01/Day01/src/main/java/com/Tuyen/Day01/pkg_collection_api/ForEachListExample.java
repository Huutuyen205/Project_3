package com.Tuyen.Day01.pkg_collection_api;

import java.util.Arrays;
import java.util.List;

public class ForEachListExample {
    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java Spring", "C#", "NetCore API", "PHP Laravel", "Javascript");

        System.out.println("Sử dụng biểu thức Lambda: ");
        // Sử dụng Lambda Expression
        languages.forEach(lang -> System.out.println(lang));

        System.out.println("Sử dụng method reference: ");
        // Sử dụng Method Reference (ngắn gọn hơn)
        languages.forEach(System.out::println);
    }
}
