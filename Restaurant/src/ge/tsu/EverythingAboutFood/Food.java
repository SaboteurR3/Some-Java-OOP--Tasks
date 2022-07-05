package ge.tsu.EverythingAboutFood;

public abstract class Food {
    protected String name;
    protected int PQuantity;
    protected float price;
    protected FoodType myFoodType;

    public abstract void getCreationYear();

    @Override
    public String toString() {
        return "Food" +
                "name: '" + name +
                ", PQuantity: " + PQuantity +
                ", price: " + price +
                ", myFoodType: " + myFoodType;
    }

    public class FoodPriceCalculator {
        public void calculateTotalPrice() {
            System.out.println("PQuantity is : " + PQuantity + ", Price is: " + price + ", TotalPrice will be: " + price * PQuantity);
        }
    }
}
