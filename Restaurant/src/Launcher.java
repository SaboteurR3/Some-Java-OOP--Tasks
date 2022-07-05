import ge.tsu.EverythingAboutFood.Food;
import ge.tsu.EverythingAboutFood.FoodType;
import ge.tsu.EverythingAboutFood.Noodles;
import ge.tsu.EverythingAboutFood.Potato;

// გიორგი ბიძიშვილი
public class Launcher {
    public static void main(String[] args) {
        Food[] myFood = new Food[]{
                new Potato("Potato",5, 1.5F, FoodType.NORMAL),
                new Potato("SweetPotato",3, 3.5F, FoodType.SWEET),
                new Potato("PotatoSoup",2, 5, FoodType.SOUP),
                new Noodles("noodles",1, 7.5F, FoodType.SPICY),
        };
        // Print foodInfo
        for(Food item : myFood)
            System.out.println(item);

        // Print food CreationYear from our array
        for(Food item : myFood)
            item.getCreationYear();

        // New potato object
        Potato otherPotato = new Potato("otherTypePotato",5, 1.5F, FoodType.SPICY);
        // FoodPriceCalculator object 'totalPrice'
        Potato.FoodPriceCalculator totalPrice = otherPotato.new FoodPriceCalculator();
        // lets print price using inner class's method 'calculateTotalPrice'
        totalPrice.calculateTotalPrice();
    }
}