package ge.tsu.EverythingAboutFood;

import java.util.Random;

public class Noodles extends Food {

    public Noodles(String name, int PQuantity, float price, FoodType myFoodType) {
        this.name = name;
        this.PQuantity = PQuantity;
        this.price = price;
        this.myFoodType = myFoodType;
    }

    @Override
    public void getCreationYear() {
        Random ran = new Random();
        int num = 1920 + ran.nextInt(1920 - 1900 + 1);
        System.out.println("Food: " + name + "\nCreationTime: " + num);
    }

    @Override
    public String toString() {
        return "Food" +
                "name: '" + name +
                ", PQuantity: " + PQuantity +
                ", price: " + price +
                ", myFoodType: " + myFoodType;
    }
}
