package seminar.six.homework;

import seminar.six.homework.interfaces.ListInterface;

import java.util.Arrays;
import java.util.Random;

public class MyList implements ListInterface {

    @Override
    public void compareArrays(double arrayFirstAverage, double arraySecondAverage) {
        if(arrayFirstAverage == arraySecondAverage) {
            System.out.println("Средние значения массивов равны");
        } else if (arrayFirstAverage > arraySecondAverage) {
            System.out.println("Первый список имеет большее среднее значение");
        } else {
            System.out.println("Второй список имеет большее среднее значение");
        }
    }

    @Override
    public double countAverageArray(int[] array) {
        double sum = 0;
        for (int i : array) {
            sum += i;
        }
        double resultAverage = Math.round(sum / array.length);
        System.out.println("\nСреднее значение списка = " + resultAverage + ".\n");
        return resultAverage;
    }

    public int[] createArray() {
        Random random = new Random();
        int[] newArray = random.ints(0, 100).distinct().limit(10).toArray();
        System.out.println(Arrays.toString(newArray));
        return newArray;
    }
}
