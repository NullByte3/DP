package club.nullbyte3.chain;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Handler compensationHandler = new CompensationClaimHandler();
        Handler contactHandler = new ContactRequestHandler();
        Handler suggestionHandler = new DevelopmentSuggestionHandler();
        Handler generalHandler = new GeneralFeedbackHandler();

        compensationHandler.setNext(contactHandler);
        contactHandler.setNext(suggestionHandler);
        suggestionHandler.setNext(generalHandler);

        List<Message> messages = new ArrayList<>();
        messages.add(new Message(MessageType.DEVELOPMENT_SUGGESTION, "Add dark mode", "email@example.com"));
        messages.add(new Message(MessageType.COMPENSATION_CLAIM, "Product arrived broken", "email@example.com"));
        messages.add(new Message(MessageType.GENERAL_FEEDBACK, "I love your service!", "email@example.com"));
        messages.add(new Message(MessageType.CONTACT_REQUEST, "Call me about a partnership", "email@example.com"));

        for (Message message : messages) {
            System.out.println("--- Sending new message ---");
            compensationHandler.handle(message);
            System.out.println();
        }
    }
}
