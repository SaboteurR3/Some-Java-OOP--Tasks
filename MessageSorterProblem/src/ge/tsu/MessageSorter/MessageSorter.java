package ge.tsu.MessageSorter;

import ge.tsu.Message.Message;
import ge.tsu.Message.MessageType;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MessageSorter {
    final Path folderPath;
    final List<Message> messages;

    public MessageSorter(Path folderPath, List<Message> messages) throws IOException {
        if (messages.isEmpty())
            throw new IllegalArgumentException("MessageList can't be empty!");
        this.folderPath = folderPath;
        this.messages = messages;
        createRootFolder();
        createSubFolders();
        sortMessages();
    }

    // RootFolder
    private void createRootFolder() throws IOException {
        if (Files.notExists(folderPath))
            Files.createDirectories(folderPath);
    }

    // SubFolders
    private void createSubFolders() throws IOException {
        for (var message : messages) {
            MessageType type = message.getType();
            Path messagePath = folderPath.resolve(type.getMessage());
            if (Files.notExists(messagePath))
                Files.createDirectories(messagePath);
        }
    }

    // Sort(and serialize) messages by its SendTime
    public void sortMessages() throws IOException {
        for (var message : messages) {
            MessageType type = message.getType();
            Path startPath = folderPath.resolve(type.getMessage());
            LocalDateTime newTime = message.getSendTime();
            String timer = newTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
            String messageFile = timer.replace(':', '-').concat(".txt");
            Path finalPath = startPath.resolve(messageFile);
            FileOutputStream fileOutputStream = new FileOutputStream(String.valueOf(finalPath));
            ObjectOutput objectOutput = new ObjectOutputStream(fileOutputStream);
            objectOutput.writeObject(message);
            objectOutput.close();
            fileOutputStream.close();
            // Set last modified time
            Files.setLastModifiedTime(finalPath, FileTime.from(message.getSendTime().toInstant(ZoneOffset.ofHours(4))));
        }
    }
}