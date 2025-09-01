package club.nullbyte3.state;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("welcome to the advanced rpg-cli based game this is, anyways.");
        System.out.print("Enter your character's name: ");
        String name = scanner.nextLine();

        Character character = new Character(name);

        while (!(character.getState() instanceof MasterState)) {
            character.displayStatus();
            System.out.println("Choose an action:");

            CharacterState state = character.getState();
            System.out.println("1. Train");
            if (state instanceof IntermediateState || state instanceof ExpertState) {
                System.out.println("2. Meditate");
            }
            if (state instanceof ExpertState) {
                System.out.println("3. Fight");
            }

            System.out.print("Your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    character.train();
                    break;
                case "2":
                    if (state instanceof IntermediateState || state instanceof ExpertState) {
                        character.meditate();
                    } else {
                        System.out.println("Invalid action for your current level.");
                    }
                    break;
                case "3":
                    if (state instanceof ExpertState) {
                        character.fight();
                    } else {
                        System.out.println("Invalid action for your current level.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        character.displayStatus();
        System.out.println("\nGG! You have reached the Master level. GAME OVER!");
        scanner.close();
    }
}
