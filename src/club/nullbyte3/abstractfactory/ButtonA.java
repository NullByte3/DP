package club.nullbyte3.abstractfactory;

public class ButtonA extends Button {
    public ButtonA(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("+-" + "-".repeat(text.length()) + "-+");
        System.out.println("| " + text + " |");
        System.out.println("+-" + "-".repeat(text.length()) + "-+");
    }
}
