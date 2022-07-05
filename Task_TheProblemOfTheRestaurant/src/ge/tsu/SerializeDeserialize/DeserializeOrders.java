package ge.tsu.SerializeDeserialize;

import java.io.*;

public class DeserializeOrders implements Serializable {
    public static void deserializeOrderList(Object order) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("Orders.txt");
        ObjectInput objectInput = new ObjectInputStream(fileInputStream);
        order = (Object) objectInput.readObject();
        fileInputStream.close();
        objectInput.close();
        System.out.println("Folder deserialized successfully!");
        System.out.println(order);
    }
}