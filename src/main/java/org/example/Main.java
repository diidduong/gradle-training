package org.example;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println("Hello, World!");

        System.out.printf("1 + 2 = %d\n", calculator.add(1, 2));

        System.out.printf("Reverse of abc is %s\n", StringUtils.reverse("abc"));
    }
}