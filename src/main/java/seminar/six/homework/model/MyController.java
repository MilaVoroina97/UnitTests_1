package seminar.six.homework.model;

import seminar.six.homework.MyList;

public class MyController {
    MyList myList;

    public MyController(){
        this.myList = new MyList();
    }

    public double countAverageArray(int[] array) {
        return myList.countAverageArray(array);
    }

    public void compareArray(double resultAverage1, double resultAverage2){
        myList.compareArrays(resultAverage1, resultAverage2);
    }

    public int[] createArray() {
        return myList.createArray();
    }
}
