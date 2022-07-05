package ge.tsu.SortOrders;

import ge.tsu.Order.Order;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.FileTime;
import java.time.ZoneOffset;
import java.util.List;

public class SortOrders {
    final Path folderPath;
    final List<Order> orders;

    public SortOrders(Path folderPath, List<Order> orders) throws IOException {
        // check ordersList
        if (orders.isEmpty())
            throw new IllegalArgumentException("OrderList can't be empty!");
        this.folderPath = folderPath;
        this.orders = orders;
        createRootFolderForOrders();
        createSubFolders();
        sortOrdersByID();
    }

    // RootFolder
    private void createRootFolderForOrders() throws IOException {
        if (Files.notExists(folderPath))
            Files.createDirectories(folderPath);
    }

    // SubFolders by Table Number
    private void createSubFolders() throws IOException {
        for (var order : orders) {
            Path ordersPath = folderPath.resolve("Table number " + order.getTableNumber());
            if (Files.notExists(ordersPath))
                Files.createDirectories(ordersPath);
        }
    }

    // Sort(and serialize) orders by its orderID
    public void sortOrdersByID() throws IOException {
        for (Order order : orders) {
            Path startPath = folderPath.resolve("Table number " + order.getTableNumber());
            Path finalPath = startPath.resolve("OrderID_" + order.getOrderID() + ".txt");

            FileOutputStream fileOutputStream = new FileOutputStream(String.valueOf(finalPath));
            ObjectOutput objectOutput = new ObjectOutputStream(fileOutputStream);
            objectOutput.writeObject(order);
            objectOutput.close();
            fileOutputStream.close();
            // Set last modified time for each order
            Files.setLastModifiedTime(finalPath, FileTime.from(order.getOrderTime().toInstant(ZoneOffset.ofHours(4))));
        }
    }
}
