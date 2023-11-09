package seminarSix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminar.six.homework.MyList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class MyListTest {

    int[] array1;
    int[] array2;
    int[] array3;
    MyList mylist;
    MyList mylistMock;
    double averageFirstArray;
    double averageSecondArray;

    @BeforeEach
    void setUp() {
        mylist = new MyList();
        mylistMock = mock(MyList.class);
        array1 = new int[]{1,1,1,1,1};
        array2 = new int[]{1,1,1,1,1};
        array3 = new int[]{1,2,1,3,4};
        averageFirstArray = 1.0;
        averageSecondArray = 2.0;
    }

    /**
     * Mock-тест - проверка метода сравнения средних значений двух списков (средние значения равны)
     */
    @Test
    void compareArray() {
        double average1 = mylist.countAverageArray(array2);
        double average2 = mylist.countAverageArray(array1);
        mylist.compareArrays(average1, average2);
    }

    /**
     * Unit, Mock-тест - проверка метода вычисления среднего значения списка
     */
    @Test
    void countAverageArray() {
        assertThat(mylist.countAverageArray(array3)).isEqualTo(2.0);
        //проверка с помощью Mock
        when(mylistMock.countAverageArray(array3)).thenReturn(averageFirstArray);
    }

    /**
     *  Unit, Mock-тест - проверка метода создания списка
     */
    @Test
    void createArray() {
        //проверка на ограничение длины списка равное 10
        assertThat(mylist.createArray().length).isEqualTo(10);
        //проверка с помощью Mock
        when(mylistMock.createArray()).thenReturn(array3);
    }

    /**
     * Mock-тест - проверка создания нового списка в классе MyList
     */
    @Test
    void createMyList(){
        when(mylistMock.createArray()).thenReturn(new int[]{1,1,1,1,1});
    }
}