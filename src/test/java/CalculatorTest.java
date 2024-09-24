import org.junit.Before;
import org.junit.Test;
import services.CalculatorService;

import java.util.Optional;

import static org.junit.Assert.*;

public class CalculatorTest {
    // Test for square_root method
    private CalculatorService calculatorService;

    @Before
    public void setup(){
        calculatorService = new CalculatorService();
    }

    @Test
    public void testSquareRootPositive() {
        assertEquals(5.0, calculatorService.sqrt(25.0), 0.0001);
    }

    @Test
    public void testSquareRootNegative() {
        assertTrue(Double.isNaN(calculatorService.sqrt(-25.0)));
    }

    // Test for factorial method
    @Test
    public void testFactorialPositive() {
        assertEquals(120.0, calculatorService.factorial(5), 0.0001);
    }

    @Test
    public void testFactorialNegative() {
        assertEquals(Optional.ofNullable(calculatorService.factorial(-5)), Optional.of(-1));
    }

    // Test for natural_log method
    @Test
    public void testNaturalLogPositive() {
        assertEquals(Math.log(10), calculatorService.logarithm(10.0), 0.0001);
    }

    @Test
    public void testNaturalLogNonPositive() {
        assertTrue(Double.isNaN(calculatorService.logarithm(0.0)));
    }

    // Test for exponent method
    @Test
    public void testExponentPositive() {
        assertEquals(8.0, calculatorService.power(2.0, 3.0), 0.0001);
    }

    @Test
    public void testExponentZero() {
        assertEquals(1.0, calculatorService.power(0.0, 0.0), 0.0001);
    }
}
