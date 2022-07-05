package ge.tsu.serializeDeserialize;

import java.io.*;

public class DeserializeMessages implements Serializable {
    public static void deserializeMessagesList(Object Message) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("Messages.txt");
        ObjectInput objectInput = new ObjectInputStream(fileInputStream);
        Message = (Object) objectInput.readObject();
        fileInputStream.close();
        objectInput.close();
        System.out.println("Folder deserialized successfully!");
        System.out.println(Message);
    }
}
