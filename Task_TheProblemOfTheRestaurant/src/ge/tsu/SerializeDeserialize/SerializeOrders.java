package ge.tsu.SerializeDeserialize;

import java.io.*;

public class SerializeOrders implements Serializable {
    public static void serializeOrderList(Object order) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("Orders.txt");
        ObjectOutput objectOutput = new ObjectOutputStream(fileOutputStream);
        objectOutput.writeObject(order);
        objectOutput.close();
        fileOutputStream.close();
        System.out.println("Folder serialized successfully!");
    }
}