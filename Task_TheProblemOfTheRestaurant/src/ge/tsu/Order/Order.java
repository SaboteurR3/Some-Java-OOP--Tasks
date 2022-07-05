package ge.tsu.Order;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Order implements Serializable {
    LocalDateTime orderTime;
    String orderID;
    String tableNumber;
    OrderType order;

    public String getTableNumber() {
        return tableNumber;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public String getOrderID() {
        return orderID;
    }

    public Order() {
    }

    public Order(LocalDateTime orderTime, String orderID, String tableNumber, OrderType order) {
        this.orderTime = orderTime;
        this.orderID = orderID;
        this.tableNumber = tableNumber;
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderTime: " + orderTime + ", OrderNumber: " + orderID + ", TableNumber: " + tableNumber + ", Order: " + order + "\n";
    }
}