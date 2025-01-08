package com.longma;

public class Calculator {
    public int add(int a, int b) {
        // Kiểm tra tràn số khi a và b đều cùng dấu
        if ((b > 0 && a > Integer.MAX_VALUE - b) || 
            (b < 0 && a < Integer.MIN_VALUE - b)) {
            throw new ArithmeticException("Overflow occurred during addition");
        }
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        long result = (long) a * b;  // Sử dụng long để tránh tràn số khi tính toán
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            throw new ArithmeticException("Multiplication result overflow.");
        }
        return (int) result;
    }
    public int divide(int a, int b) {
        if(b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
    
}
