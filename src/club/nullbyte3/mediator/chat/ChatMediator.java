package club.nullbyte3.mediator.chat;

import java.util.List;

public interface ChatMediator {
    void register(ChatClient client);
    void unregister(ChatClient client); // not used, but yeh.
    void send(String from, String to, String message);
    List<String> getUsernames();
}
