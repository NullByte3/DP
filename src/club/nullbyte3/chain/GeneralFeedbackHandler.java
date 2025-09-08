package club.nullbyte3.chain;

public class GeneralFeedbackHandler extends Handler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.GENERAL_FEEDBACK) {
            System.out.println("Handling general feedback from " + message.getSenderEmail());
            System.out.println("Content: " + message.getContent());
            System.out.println("Feedback analyzed. Sending thank you note.");
        } else if (next != null) {
            next.handle(message);
        }
    }
}
