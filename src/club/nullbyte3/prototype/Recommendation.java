package club.nullbyte3.prototype;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Recommendation implements Cloneable {
    private String targetAudience;
    private List<Book> books;

    public Recommendation(String targetAudience) {
        this(targetAudience, new ArrayList<>());
    }

    public Recommendation(String targetAudience, List<Book> books) {
        this.targetAudience = Objects.requireNonNull(targetAudience, "targetAudience must not be null");
        this.books = new ArrayList<>(Objects.requireNonNull(books, "books must not be null"));
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = Objects.requireNonNull(targetAudience, "targetAudience must not be null");
    }

    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public void addBook(Book book) {
        books.add(Objects.requireNonNull(book, "book must not be null"));
    }

    public boolean removeBook(int index) {
        if (index < 0 || index >= books.size()) {
            return false;
        }
        books.remove(index);
        return true;
    }

    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    @Override
    public Recommendation clone() {
        try {
            Recommendation copy = (Recommendation) super.clone();
            List<Book> clonedBooks = new ArrayList<>(books.size());
            for (Book b : books) {
                clonedBooks.add(b.clone());
            }
            copy.books = clonedBooks;
            return copy;
        } catch (CloneNotSupportedException e) {
            // NOT CLONABLE BOOK!!!!!!!!!!!!!
            throw new AssertionError("Recommendation cloning failed", e);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Recommendation for: ").append(targetAudience).append('\n');
        if (books.isEmpty()) {
            sb.append("  (no books)\n");
        } else {
            for (int i = 0; i < books.size(); i++) {
                sb.append("  ").append(i).append(". ").append(books.get(i)).append('\n');
            }
        }
        return sb.toString();
    }
}
