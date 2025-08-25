package club.nullbyte3.abstractfactory;

public class ButtonB extends Button {
    public ButtonB(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("*=" + "=".repeat(text.length()) + "=*");
        System.out.println("* " + text + " *");
        System.out.println("*=" + "=".repeat(text.length()) + "=*");
    }
}
