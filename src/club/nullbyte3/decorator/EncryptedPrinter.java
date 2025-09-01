package club.nullbyte3.decorator;

import java.util.Base64;

public class EncryptedPrinter extends PrinterDecorator {
    public EncryptedPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
        String encryptedMessage = encrypt(message);
        super.print(encryptedMessage);
    }

    // BASE-64 IS NOT AN ECRNYPTION ALGORITHM!!!!!!!! THIS IS JUST FOR THE SAKE OF THE ASSINGMENT -VIVSAM.
    private String encrypt(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
