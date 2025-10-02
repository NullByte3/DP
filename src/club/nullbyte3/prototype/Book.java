package club.nullbyte3.prototype;

import java.util.Objects;

public class Book implements Cloneable {
    private final String author;
    private final String title;
    private final String genre;
    private final int publicationYear;

    public Book(String author, String title) {
        this(author, title, "Unknown", 0);
    }

    public Book(String author, String title, String genre, int publicationYear) {
        this.author = Objects.requireNonNull(author, "author must not be null");
        this.title = Objects.requireNonNull(title, "title must not be null");
        this.genre = genre == null ? "Unknown" : genre;
        this.publicationYear = publicationYear;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public Book clone() {
        try {
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Book cloning failed", e);
        }
    }

    @Override
    public String toString() {
        String year = publicationYear > 0 ? String.valueOf(publicationYear) : "n/a";
        return "\"" + title + "\" by " + author + " (" + genre + ", " + year + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o; // We're using Java 8.
        return publicationYear == book.publicationYear
                && author.equals(book.author)
                && title.equals(book.title)
                && genre.equals(book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, genre, publicationYear);
    }
}
