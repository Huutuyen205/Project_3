package com.Tuyen.Day01.pkg_default_method;

public interface demo {
    void draw();
    default void setColor(String color) {
        System.out.println("Vẽ hình với màu:" + color);
    }
}
