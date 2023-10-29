import org.junit.jupiter.api.Test;
import seminar.first.homework.calculator.Calculator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import  static org.assertj.core.api.Assertions.*;

public class CalculatorTest {


        @Test
        public void checkPriceCalculation(){

            Calculator calculator = new Calculator();
            assertThat(calculator.calculateDiscount(100.0, 10.0)).isEqualTo(90.0);
        }

        @Test
        public void testPriceArgument(){

            Calculator calculator = new Calculator();
            assertThat(calculator.calculateDiscount(0.0, 30.0)).isEqualTo(0.0);
        }

        @Test
        public void testDiscountArgument(){

            Calculator calculator = new Calculator();
            assertThat(calculator.calculateDiscount(40.0, 0)).isEqualTo(40.0);

        }

        @Test
        public void testNegativePrice(){

            Calculator calculator = new Calculator();
            assertThatThrownBy(() -> calculator.calculateDiscount(-50.0, 90)).
                    isInstanceOf(ArithmeticException.class).hasMessage("Price cannot be less than 0");

        }

    @Test
    public void testNegativeDiscount(){

        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.calculateDiscount(880.0, -60.0)).
                isInstanceOf(ArithmeticException.class).hasMessage("Discount cannot be less than 0");

    }

    @Test
    public void testExtremalAmountOfDiscount(){

        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.calculateDiscount(700.0, 150.0)).
                isInstanceOf(ArithmeticException.class).hasMessage("Discount cannot be more than 100%");

    }

    @Test
    public void getOperandCompletesCorrectlyWithNumbers(){
            String testValue = "9";
            ByteArrayInputStream in = new ByteArrayInputStream(testValue.getBytes());
            InputStream inputStream = System.in;
            System.setIn(in);

            Calculator calculator = new Calculator();
            calculator.getOperand();
            System.out.println(testValue);
            System.setIn(inputStream);
    }

    @Test
    public void getOperandCompletesCorrectlyWithNotNumbers(){
        String testValue = "k";
        ByteArrayInputStream in = new ByteArrayInputStream(testValue.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        InputStream inputStream = System.in;
        System.setIn(in);
        System.setOut(new PrintStream(out));

        Calculator calculator = new Calculator();
        assertThatThrownBy(calculator::getOperand).isInstanceOf(IllegalStateException.class).
                describedAs("Incorrect data enter. ");
        System.setIn(inputStream);
        System.setOut(null);
    }

    /* Проверка вычислений на пограничные значения:
    * */

    @Test
    public void testCalculateMaxAndMinNumber(){

        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(Integer.MAX_VALUE - 1, 1 ,'+')).
                isEqualTo(Integer.MAX_VALUE);
        assertThat(calculator.calculation(Integer.MIN_VALUE + 1,  - 1, '+')).
                isEqualTo(Integer.MIN_VALUE);
    }




}
