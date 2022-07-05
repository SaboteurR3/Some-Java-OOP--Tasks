package ge.tsu;

import java.util.Comparator;

public class CompareSpeed implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Car firstCar = (Car) o1;
        Car secondCar = (Car) o2;
        return Float.compare(firstCar.speed, secondCar.speed);
    }
}