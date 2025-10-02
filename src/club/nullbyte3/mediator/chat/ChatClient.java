package club.nullbyte3.mediator.chat;

public interface ChatClient {
    String getUsername();
    void receive(String from, String message);
    void refreshRecipients();
}
