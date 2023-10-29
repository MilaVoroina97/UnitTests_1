package seminarTwo.homework;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminar.two.homework.Car;
import seminar.two.homework.Motorcycle;
import seminar.two.homework.Vehicle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;


public class VehicleTest {

    Car car;
    Motorcycle motorcycle;

    @BeforeEach
    public void setUp(){

        car = new Car("Skoda","Yetti",2005);
        motorcycle = new Motorcycle("Toyota","X200",2001);

    }


    /*Тест №1: Проверить, что экземпляр объекта Car также является экземпляром транспортного средства
     (используя оператор instanceof).
    * */
    @Test
    public void testCarIsInstanseOfVehicle(){

        assertTrue(car instanceof Vehicle);
    }

    /*Тест №2: Проверить, что объект Car создается с 4-мя колесами.
    * */

    @Test
    public void testCarHasFourWheels(){

        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    /*Тест №3: Проверить, что объект Motorcycle создается с 2-мя колесами.
    * */

    @Test
    public void testMotorcycleHasTwoWheels(){
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    /*Тест №4: Проверить, что объект Car развивает скорость 60 в режиме тестового вождения (используя метод testDrive()).
    * */

    @Test
    public void checkCarTestDriveSpeed(){

        car.testDrive();
        assertEquals(60,car.getSpeed());
    }

    /*Тест №5:  Проверить, что объект Motorcycle развивает скорость 75 в режиме тестового вождения
     (используя метод testDrive()).
    * */

    @Test
    public void checkMotorcycleTestDriveSpeed(){

        motorcycle.testDrive();
        assertEquals(75,motorcycle.getSpeed());
    }

    /*Тест №6: Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта)
    машина останавливается (speed = 0).
    * */

    @Test
    public void testCarParkingSpeed(){
        car.testDrive();
        car.park();
        assertEquals(0,car.getSpeed());
    }

    /*Тест №7: Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта)
    мотоцикл останавливается (speed = 0).
    * */

    @Test
    public void testMotorcycleParkingSpeed(){
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(0,motorcycle.getSpeed());
    }




}
