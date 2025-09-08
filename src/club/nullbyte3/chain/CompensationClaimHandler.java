package club.nullbyte3.chain;

public class CompensationClaimHandler extends Handler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.COMPENSATION_CLAIM) {
            System.out.println("Handling compensation claim from " + message.getSenderEmail());
            System.out.println("Content: " + message.getContent());
            System.out.println("Claim reviewed. Sending response to " + message.getSenderEmail());
        } else if (next != null) {
            next.handle(message);
        }
    }
}
