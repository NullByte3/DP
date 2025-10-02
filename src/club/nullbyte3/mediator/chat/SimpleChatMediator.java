package club.nullbyte3.mediator.chat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleChatMediator implements ChatMediator {
    private final Map<String, ChatClient> clients = new ConcurrentHashMap<>();

    @Override
    public void register(ChatClient client) {
        clients.put(client.getUsername(), client);
        notifyAllClients();
    }

    @Override
    public void unregister(ChatClient client) {
        clients.remove(client.getUsername());
        notifyAllClients();
    }

    @Override
    public void send(String from, String to, String message) {
        ChatClient recipient = clients.get(to);
        if (recipient != null) {
            recipient.receive(from, message);
        }
    }

    @Override
    public List<String> getUsernames() {
        return new ArrayList<>(clients.keySet());
    }

    private void notifyAllClients() {
        for (ChatClient c : clients.values()) {
            c.refreshRecipients();
        }
    }
}
