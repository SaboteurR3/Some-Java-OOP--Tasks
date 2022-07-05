package ge.tsu.serializeDeserialize;

import java.io.*;

public class SerializeMessages implements Serializable {
    public static void serializeMessages(Object Message) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("Messages.txt");
        ObjectOutput objectOutput = new ObjectOutputStream(fileOutputStream);
        objectOutput.writeObject(Message);
        objectOutput.close();
        fileOutputStream.close();
        System.out.println("Folder serialized successfully!");
    }
}
