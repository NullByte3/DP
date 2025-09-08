package club.nullbyte3.chain;

public class ContactRequestHandler extends Handler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.CONTACT_REQUEST) {
            System.out.println("Handling contact request from " + message.getSenderEmail());
            System.out.println("Content: " + message.getContent());
            System.out.println("Forwarding to sales department.");
        } else if (next != null) {
            next.handle(message);
        }
    }
}
