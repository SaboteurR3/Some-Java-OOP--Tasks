package ge.tsu.Message;

public enum MessageType {
    HIGH("High"),MEDIUM("Medium"),LIGHT("Light"),NONE("None");
    private final String Message;

    public String getMessage() {
        return Message;
    }

    MessageType(String message) {
        Message = message;
    }
}