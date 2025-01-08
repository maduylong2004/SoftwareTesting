import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.longma.Calculator;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    // Kiểm thử phép cộng
    @Test
    void testAdd() {
        assertAll("Addition tests",
            () -> assertEquals(5, calculator.add(2, 3), "2 + 3 should equal 5"),
            () -> assertEquals(0, calculator.add(-1, 1), "-1 + 1 should equal 0"),
            () -> assertEquals(-2, calculator.add(-1, -1), "-1 + -1 should equal -2")
        );
    }

    // Kiểm thử phép trừ
    @Test
    void testSubtract() {
        assertAll("Subtraction tests",
            () -> assertEquals(1, calculator.subtract(3, 2), "3 - 2 should equal 1"),
            () -> assertEquals(-2, calculator.subtract(-1, 1), "-1 - 1 should equal -2"),
            () -> assertEquals(0, calculator.subtract(2, 2), "2 - 2 should equal 0")
        );
    }

    // Kiểm thử phép nhân
    @Test
    void testMultiply() {
        assertAll("Multiplication tests",
            () -> assertEquals(6, calculator.multiply(2, 3), "2 * 3 should equal 6"),
            () -> assertEquals(0, calculator.multiply(0, 5), "0 * 5 should equal 0"),
            () -> assertEquals(-10, calculator.multiply(-2, 5), "-2 * 5 should equal -10")
        );
    }

    // Kiểm thử phép chia
    @Test
    void testDivide() {
        assertAll("Division tests",
            () -> assertEquals(2, calculator.divide(6, 3), "6 / 3 should equal 2"),
            () -> assertEquals(-3, calculator.divide(-6, 2), "-6 / 2 should equal -3"),
            () -> assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0), "Division by zero should throw ArithmeticException")
        );
    }

    // Kiểm thử sự kết hợp phép cộng và nhân
    @Test
    void testAddThenMultiply() {
        int result = calculator.multiply(calculator.add(2, 3), 4); // (2 + 3) * 4 = 20
        assertEquals(20, result, "(2 + 3) * 4 should equal 20");
    }

    // Kiểm thử sự kết hợp phép chia và trừ
    @Test
    void testDivideThenSubtract() {
        int result = calculator.subtract(7, (int) calculator.divide(10, 2)); // 7 - (10 / 2) = 2
        assertEquals(2, result, "7 - (10 / 2) should equal 2");
    }

    // Kiểm thử giá trị biên trong phép cộng và chia
    @Test
    void testAddThenDivideBoundary() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(calculator.add(Integer.MAX_VALUE, 1), 0),
            "Division by zero should throw ArithmeticException.");
    }

    // Kiểm thử phép nhân và trừ với số âm
    @Test
    void testMultiplyThenSubtractWithNegativeValues() {
        int result = calculator.subtract(10, calculator.multiply(-3, 5)); // 10 - (-3 * 5) = 25
        assertEquals(25, result, "10 - (-3 * 5) should equal 25");
    }

    // Kiểm thử hiệu năng phép cộng
    @Test
    void testAddPerformance() {
        assertTimeoutPreemptively(java.time.Duration.ofMillis(1), () -> {
            calculator.add(1000000, 2000000);
        }, "Addition operation should complete within 1 millisecond.");
    }

    // Kiểm thử hiệu năng phép nhân
    @Test
    void testMultiplyPerformance() {
        assertTimeoutPreemptively(java.time.Duration.ofMillis(1), () -> {
            calculator.multiply(1000000, 2000000);
        }, "Multiplication operation should complete within 1 millisecond.");
    }

    // Kiểm thử tràn số khi nhân
    @Test
    void testMultiplyWithLargeValues() {
        assertThrows(ArithmeticException.class, () -> calculator.multiply(Integer.MAX_VALUE, 2),
            "Multiplying large values should throw ArithmeticException due to overflow.");
    }
}
