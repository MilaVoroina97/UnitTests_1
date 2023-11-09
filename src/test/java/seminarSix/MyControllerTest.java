package seminarSix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminar.six.homework.MyList;
import seminar.six.homework.model.MyController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class MyControllerTest {

    int[] array;
    double averageFirstArray;
    double averageSecondArray;
    MyController controllerMock;

    @BeforeEach
    void setUp() {
        array = new int[]{1, 1, 1, 1, 1};
        averageFirstArray = 1.0;
        averageSecondArray = 2.0;
        controllerMock = mock(MyController.class);
    }

    /**
     * Mock-тест - проверка, что в контроллере при вызове метода сравнения средних
     * значений возвращается корректное значение averageArray
     */
    @Test
    void countAverageArray() {
        when(controllerMock.countAverageArray(array)).thenReturn(averageFirstArray);
    }

    /**
     * Mock-тест - проверка корректности сравнения средних значений массивов
     */
    @Test
    void compareArray() {
        controllerMock.compareArray(averageFirstArray, averageSecondArray);
        verify(controllerMock, times(1)).compareArray(averageFirstArray, averageSecondArray);
    }

    /**
     * Mock-тест - проверка создания в контроллере нового массива с заданными значениями
     */
    @Test
    void createArray() {
        when(controllerMock.createArray()).thenReturn(array);
    }
}
