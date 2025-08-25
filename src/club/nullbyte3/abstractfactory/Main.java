package club.nullbyte3.abstractfactory;

public class Main {
    public static void main(String[] args) {
        // Create Style A UI elements
        UIFactory factoryA = new AFactory();
        System.out.println("Style A:");
        
        Button buttonA = factoryA.createButton("Click me");
        TextField textFieldA = factoryA.createTextField("Enter text");
        Checkbox checkboxA = factoryA.createCheckbox("Enable feature");
        
        buttonA.display();
        textFieldA.display();
        checkboxA.display();
        checkboxA.toggle();
        checkboxA.display();

        System.out.println("\nChanging text:");
        buttonA.setText("Updated!");
        buttonA.display();

        // Create Style B UI elements
        System.out.println("\nStyle B:");
        UIFactory factoryB = new BFactory();
        
        Button buttonB = factoryB.createButton("Click me");
        TextField textFieldB = factoryB.createTextField("Enter text");
        Checkbox checkboxB = factoryB.createCheckbox("Enable feature");
        
        buttonB.display();
        textFieldB.display();
        checkboxB.display();
        checkboxB.toggle();
        checkboxB.display();
    }
}
