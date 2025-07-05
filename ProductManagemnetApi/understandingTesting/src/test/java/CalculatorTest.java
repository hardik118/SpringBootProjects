import org.example.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


 public class CalculatorTest {
    private  final Calculator calculator= new Calculator();

    @Test
     void testAddition(){
        int result= calculator.add(2,3);
        assertEquals(5, result);
    }
    @Test
    void testDivisionByZero(){
        assertThrows(IllegalArgumentException.class, ()->{
            calculator.div(1,0);
        });
    }

    @Test
     void testSubtract(){
        int result= calculator.sub(4,2);
        assertEquals(2, result);
    }

    @Test
     void testMultiplication() {
        int result = calculator.mul(2, 3);
        assertEquals(6, result);

    }



}
