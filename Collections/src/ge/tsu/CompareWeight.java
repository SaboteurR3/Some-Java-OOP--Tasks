package ge.tsu;

import java.util.Comparator;

public class CompareWeight implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Car first = (Car) o1;
        Car second = (Car) o2;
        return Float.compare(first.weight, second.weight);
    }
}
