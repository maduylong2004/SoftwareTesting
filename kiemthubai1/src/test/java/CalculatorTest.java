import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.longma.Calculator;


public class CalculatorTest {

    Calculator calculator = new Calculator(); // Tạo một instance của lớp Calculator

    @Test
    void testAdd() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(0, calculator.add(-1, 1));
        assertEquals(-2, calculator.add(-1, -1));
    }

    @Test
    void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
        assertEquals(-2, calculator.subtract(-1, 1));
        assertEquals(0, calculator.subtract(2, 2));
    }

    @Test
    void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(0, calculator.multiply(0, 5));
        assertEquals(-10, calculator.multiply(-2, 5));
    }

    @Test
    void testDivide() {
        assertEquals(2, calculator.divide(6, 3));
        assertEquals(-3, calculator.divide(-6, 2));
        assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
    }

    // Kiểm thử sự tương tác giữa các phép cộng và nhân
    @Test
    public void testAddThenMultiply() {
        int addResult = calculator.add(2, 3); // 2 + 3 = 5
        int multiplyResult = calculator.multiply(addResult, 4); // 5 * 4 = 20
        assertEquals(20, multiplyResult, "The result of add then multiply should be correct.");
    }

    // Kiểm thử sự tương tác giữa phép chia và trừ
    @Test
    public void testDivideThenSubtract() {
        double divideResult = calculator.divide(10, 2); // 10 / 2 = 5
        int subtractResult = calculator.subtract(7, (int) divideResult); // 7 - 5 = 2
        assertEquals(2, subtractResult, "The result of divide then subtract should be correct.");
    }

    // Kiểm thử sự tương tác giữa phép cộng và chia với các giá trị biên
    @Test
    public void testAddThenDivide() {
        int addResult = calculator.add(Integer.MAX_VALUE, 1); // Kiểm thử giá trị biên
        assertThrows(ArithmeticException.class, () -> calculator.divide(addResult, 0), 
                        "Division by zero should throw ArithmeticException.");
    }

    // Kiểm thử sự tương tác giữa phép nhân và trừ với số âm
    @Test
    public void testMultiplyThenSubtractWithNegativeValues() {
        int multiplyResult = calculator.multiply(-3, 5); // -3 * 5 = -15
        int subtractResult = calculator.subtract(10, multiplyResult); // 10 - (-15) = 25
        assertEquals(25, subtractResult, "The result of multiply then subtract with negative values should be correct.");
    }

    @Test
    public void testAddPerformance() {
        long startTime = System.nanoTime();
        calculator.add(1000000, 2000000); // Thực hiện phép cộng
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Add performance test took: " + duration + " nanoseconds");
        assertTrue(duration < 1000000, "Performance test failed. The operation took too long.");
    }

    @Test
    public void testMultiplyPerformance() {
        long startTime = System.nanoTime();
        try {
            calculator.multiply(1000000, 2000000); // Kiểm tra hiệu suất
        } catch (ArithmeticException e) {
            // Bắt ngoại lệ nếu có tràn số và thông báo
            System.out.println("Multiplication caused overflow: " + e.getMessage());
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Multiply performance test took: " + duration + " nanoseconds");
        assertTrue(duration < 1000000, "Performance test failed. The operation took too long.");
    }
    @Test
    public void testMultiplyWithLargeValues() {
        assertThrows(ArithmeticException.class, () -> calculator.multiply(Integer.MAX_VALUE, 2), 
            "Multiplying with values too large should throw ArithmeticException due to overflow.");
    }
}

