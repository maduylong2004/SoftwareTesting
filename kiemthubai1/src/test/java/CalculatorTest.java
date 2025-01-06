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
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(1, 0));
    }
}

