package ge.tsu;

import ge.tsu.Message.Message;
import ge.tsu.Message.MessageType;
import ge.tsu.MessageSorter.MessageSorter;
import ge.tsu.serializeDeserialize.DeserializeMessages;
import ge.tsu.serializeDeserialize.SerializeMessages;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Launcher {
    public static void main(String[] args) {
        try {
            List<Message> messages = new ArrayList<>();
            messages.add(new Message(LocalDateTime.now().minusDays(25), "you jerk!", MessageType.HIGH));
            messages.add(new Message(LocalDateTime.now(), "prick", MessageType.HIGH));
            messages.add(new Message(LocalDateTime.now().minusDays(7), "you are a freak", MessageType.HIGH));
            messages.add(new Message(LocalDateTime.now(), "loser", MessageType.MEDIUM));
            messages.add(new Message(LocalDateTime.now().minusDays(4), "you are an idiot", MessageType.MEDIUM));
            messages.add(new Message(LocalDateTime.now().minusDays(15), "you dumb", MessageType.MEDIUM));
            messages.add(new Message(LocalDateTime.now(), "shorty", MessageType.LIGHT));
            messages.add(new Message(LocalDateTime.now().minusDays(13), "you thin", MessageType.LIGHT));
            messages.add(new Message(LocalDateTime.now(), "weak", MessageType.LIGHT));
            messages.add(new Message(LocalDateTime.now().minusDays(8), "Hey guys", MessageType.NONE));

            // serialize Messages.txt 
            SerializeMessages.serializeMessages(messages);

            // deserialize Messages.txt - ს 
            DeserializeMessages.deserializeMessagesList(messages);

            // Sort offensive words
            Path rootPath = Paths.get("RootFolderForMessages");
            MessageSorter Sorter = new MessageSorter(rootPath, messages);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Messages are sorted");
        }
    }
}