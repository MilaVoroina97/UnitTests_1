package org.example;

import  static org.assertj.core.api.Assertions.*;

public class CalculatorTest {


    protected Calculator calculator;

    public CalculatorTest(){

        this.calculator = new Calculator();
    }
    public void calculateDiscountTest(){

        /* Тест №1: проверка корректности расчета скидки:
         * */

        assertThat(calculator.calculateDiscount(100.0,10.0)).isEqualTo(90.0);

        /* Тест №2: проверка расчета с пограничным значением аргумента price равное 0:
        * */

        assertThat(calculator.calculateDiscount(0.0,30.0)).isEqualTo(0.0);

        /* Тест №3: проверка расчета с пограничным значением аргумента discount равное 0:
        * */

        assertThat(calculator.calculateDiscount(40.0,0)).isEqualTo(40.0);

        /* Тест №4: проверка на обработку исключения при отрицательной цене:
        * */

        assertThatThrownBy(() -> calculator.calculateDiscount(-50.0,90)).
                isInstanceOf(ArithmeticException.class).hasMessage("Price cannot be less than 0");

        /* Тест №5: проверку на обработку исключения при отрицательной скидке:
        * */

        assertThatThrownBy(() -> calculator.calculateDiscount(880.0, -60.0)).
                isInstanceOf(ArithmeticException.class).hasMessage("Discount cannot be less than 0");

        /* Тест №6: проверка на обработку исключения при скидке большей 100%:
        * */

        assertThatThrownBy(() -> calculator.calculateDiscount(700.0,150.0)).
                isInstanceOf(ArithmeticException.class).hasMessage("Discount cannot be more than 100%");
    }
}
