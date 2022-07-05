package ge.tsu.Message;

import java.io.Serializable;
import java.nio.file.Path;
import java.time.LocalDateTime;

public class Message implements Serializable {
    LocalDateTime sendTime;
    String text;
    MessageType type;

    public Message() {
    }

    public Message(LocalDateTime sendTime, String text, MessageType type) {
        this.sendTime = sendTime;
        this.text = text;
        this.type = type;
    }

    public MessageType getType() {
        return type;
    }

    public LocalDateTime getSendTime() {
        return sendTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                ", sendTime=" + sendTime +
                ", type=" + type +
                '}';
    }
}
