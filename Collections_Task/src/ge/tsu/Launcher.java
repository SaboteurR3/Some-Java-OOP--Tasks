package ge.tsu;

import java.util.*;

public class Launcher {
    public static void main(String[] args) {
        // First Task
        List<Car> carList = new ArrayList<Car>();
        carList.add(new Mercedes("MercedesModel1", 300, 1.8f));
        carList.add(new Porsche("PorscheModel1", 350, 1.5f));
        carList.add(new Mercedes("MercedesModel2", 280, 1.8f));
        carList.add(new Bmw("BMWModel1", 300, 1.7f));
        System.out.println("Before Sorting by weight!");
        for (Car car : carList) {
            System.out.println(car);
        }
        Collections.sort(carList, new CompareWeight().thenComparing(new CompareSpeed().reversed()));
        System.out.println("\nAfter Sorting by weight!(thenComparing by Speed but Reversed (^_^) )");
        for (Car car : carList) {
            System.out.println(car);
        }
        // Second Task
        secondTask(carList);
    }
    public static void secondTask(List<Car> carList) {
        Porsche newPorsche = new Porsche("PorscheModel2", 380, 1.8f);
        Map myMap = new HashMap<>();
        // Select all cars which has less weight than newPorsche
        List<Car> secondList = new ArrayList<Car>();
        for (Car car : carList) {
            if(car.weight < newPorsche.weight)
                secondList.add(car);
        }
        myMap.put(newPorsche, secondList);
        System.out.println("\n" + Arrays.asList(myMap));
    }
}