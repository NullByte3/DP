package club.nullbyte3.prototype;

import java.util.Scanner;

public class Main {
    private final RecommendationRepository repo;
    private final Scanner scanner;

    public Main() {
        this.repo = new RecommendationRepository();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        System.out.println("Book Recommendations (Prototype Pattern)");
        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Choose an option: ");
            switch (choice) {
                case 1 -> listRecommendations();
                case 2 -> viewRecommendation();
                case 3 -> createFromScratch();
                case 4 -> cloneAndModify();
                case 0 -> running = false;
                default -> System.out.println("Unknown option. Try again.");
            }
        }
        System.out.println("Goodbye!");
    }

    private void printMenu() {
        System.out.println();
        System.out.println("1) List recommendations");
        System.out.println("2) View recommendation details");
        System.out.println("3) Create new recommendation from scratch");
        System.out.println("4) Clone existing recommendation and modify");
        System.out.println("0) Exit");
    }

    private void listRecommendations() {
        var all = repo.all();
        if (all.isEmpty()) {
            System.out.println("No recommendations available.");
            return;
        }
        for (int i = 0; i < all.size(); i++) {
            var rec = all.get(i);
            System.out.printf("%d) %s (%d books)%n", i, rec.getTargetAudience(), rec.getBooks().size());
        }
    }

    private void viewRecommendation() {
        listRecommendations();
        int idx = readInt("Enter index to view: ");
        var rec = repo.get(idx);
        if (rec == null) {
            System.out.println("Invalid index.");
            return;
        }
        System.out.println(rec);
    }

    private void createFromScratch() {
        String audience = readLine("Target audience: ");
        var rec = new Recommendation(audience);
        editBooksInteractive(rec);
        repo.add(rec);
        System.out.println("Saved new recommendation list.");
    }

    private void cloneAndModify() {
        listRecommendations();
        int idx = readInt("Enter index to clone: ");
        var original = repo.get(idx);
        if (original == null) {
            System.out.println("Invalid index.");
            return;
        }
        var clone = original.clone();
        System.out.println("Cloned recommendation:");
        System.out.println(clone);

        String changeAudience = readLine("Change target audience? (y/N): ").trim().toLowerCase();
        if (changeAudience.equals("y") || changeAudience.equals("yes")) {
            String audience = readLine("New target audience: ");
            clone.setTargetAudience(audience);
        }
        editBooksInteractive(clone);
        repo.add(clone);
        System.out.println("Saved cloned recommendation list.");
    }

    private void editBooksInteractive(Recommendation rec) {
        boolean editing = true;
        while (editing) {
            System.out.println();
            System.out.println("Current list:");
            System.out.println(rec);
            System.out.println("a) Add book");
            System.out.println("r) Remove book by index");
            System.out.println("d) Done");
            String op = readLine("Choose action (a/r/d): ").trim().toLowerCase();
            switch (op) {
                case "a" -> addBookPrompt(rec);
                case "r" -> {
                    int idx = readInt("Index to remove: ");
                    if (!rec.removeBook(idx)) {
                        System.out.println("Invalid index.");
                    }
                }
                case "d" -> editing = false;
                default -> System.out.println("Unknown option.");
            }
        }
    }

    private void addBookPrompt(Recommendation rec) {
        String title = readLine("Title: ");
        String author = readLine("Author: ");
        String genre = readLine("Genre (optional, press Enter for Unknown): ");
        if (genre.isBlank()) genre = "Unknown";
        int year = readIntAllowEmpty("Publication year (optional): ", 0);
        rec.addBook(new Book(author, title, genre, year));
    }

    private int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String line = scanner.nextLine();
                return Integer.parseInt(line.trim());
            } catch (Exception e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private int readIntAllowEmpty(String prompt, int defaultValue) {
        while (true) {
            try {
                System.out.print(prompt);
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) return defaultValue;
                return Integer.parseInt(line);
            } catch (Exception e) {
                System.out.println("Please enter a valid integer or leave empty.");
            }
        }
    }

    private String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
