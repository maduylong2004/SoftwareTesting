package com.longma;
public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("2 + 3 = " + calculator.add(2, 3));
        System.out.println("5 - 2 = " + calculator.subtract(5, 2));
        System.out.println("4 * 2 = " + calculator.multiply(4, 2));
        System.out.println("10 / 2 = " + calculator.divide(10, 2));
    }

}