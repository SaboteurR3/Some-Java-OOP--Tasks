package ge.tsu;

import ge.tsu.Order.Order;
import ge.tsu.Order.OrderType;
import ge.tsu.SerializeDeserialize.SerializeOrders;
import ge.tsu.SerializeDeserialize.DeserializeOrders;
import ge.tsu.SortOrders.SortOrders;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Launcher {
    public static void main(String[] args) {
        try {
            // Create some orders
            List<Order> orders = new ArrayList<>();
            orders.add(new Order(LocalDateTime.now().minusMinutes(25), "005", "05", OrderType.PIZZA));
            orders.add(new Order(LocalDateTime.now().minusMinutes(10), "003", "07", OrderType.MUSHROOM));
            orders.add(new Order(LocalDateTime.now().minusMinutes(7), "006", "07", OrderType.POTATO));
            orders.add(new Order(LocalDateTime.now(), "001", "03", OrderType.SOUP));
            orders.add(new Order(LocalDateTime.now().minusMinutes(4), "007", "03", OrderType.TEA));
            orders.add(new Order(LocalDateTime.now().minusMinutes(15), "004", "01", OrderType.POTATO));
            orders.add(new Order(LocalDateTime.now().minusMinutes(5), "002", "11", OrderType.CAKE));
            orders.add(new Order(LocalDateTime.now().minusMinutes(13), "008", "11", OrderType.TEA));
            orders.add(new Order(LocalDateTime.now().minusMinutes(17), "009", "11", OrderType.POTATO));
            orders.add(new Order(LocalDateTime.now().minusMinutes(8), "010", "11", OrderType.PIZZA));

            // Write orders in a 'Orders.txt' file(Serialaize)
            SerializeOrders.serializeOrderList(orders);

            // Deserialaize 'Orders.txt' file
            DeserializeOrders.deserializeOrderList(orders);

            // Sort folders by Table numbers and then sort files by orderNumber
            Path rootPath = Paths.get("RootFolderForOrders");
            SortOrders orderSorter = new SortOrders(rootPath, orders);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Sorted by table numbers and by order number!");
        }
    }
}