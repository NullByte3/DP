package club.nullbyte3.chain;

public class DevelopmentSuggestionHandler extends Handler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.DEVELOPMENT_SUGGESTION) {
            System.out.println("Handling development suggestion from " + message.getSenderEmail());
            System.out.println("Content: " + message.getContent());
            System.out.println("Suggestion logged for prioritization.");
        } else if (next != null) {
            next.handle(message);
        }
    }
}
