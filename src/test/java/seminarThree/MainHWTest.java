package seminarThree;

import org.junit.jupiter.api.Test;
import seminar.three.homework.MainHW;

import static org.junit.jupiter.api.Assertions.*;

public class MainHWTest {

    /* Тест №1: Проверка правильности результата метода поиска четного числа - если число четное, то метод вернет true
    * */

    @Test
    void testEvenNumber() {
        assertTrue(MainHW.evenOddNumber(4));
    }

    /* Тест №2: Проверка правильности результата метода поиска четного числа - если число четное, то метод вернет false
    * */

    @Test
    void testOddNumber() {
        assertFalse(MainHW.evenOddNumber(3));
    }

    /* Тест №3: Проверка метода numberInInterval на пограничные значения:
    * */

    @Test
    void testNumberIntervalLowBorder(){
        assertTrue(MainHW.numberInInterval(25));//Нижняя граница интервала
    }

    @Test
    void testNumberIntervalHighBorder(){
        assertTrue(MainHW.numberInInterval(100));//Верхняя граница интервала
    }

    @Test
    void testNumberIntervalMiddleBorder(){
        assertTrue(MainHW.numberInInterval(50));//Середина интервала
    }

    @Test
    void testNumberIntervalIncorrectLowBorder(){
        assertFalse(MainHW.numberInInterval(24));//Ниже заданного интервала
    }
    @Test
    void testNumberIntervalIncorrectHighBorder(){
        assertFalse(MainHW.numberInInterval(101));//Выше заданного интервала
    }

}
