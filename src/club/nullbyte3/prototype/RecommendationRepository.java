package club.nullbyte3.prototype;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecommendationRepository {
    private final List<Recommendation> recommendations = new ArrayList<>();

    public RecommendationRepository() {
        seedSamples();
    }

    public List<Recommendation> all() {
        return Collections.unmodifiableList(recommendations);
    }

    public void add(Recommendation recommendation) {
        recommendations.add(recommendation);
    }

    public Recommendation get(int index) {
        if (index < 0 || index >= recommendations.size()) {
            return null;
        }
        return recommendations.get(index);
    }

    private void seedSamples() {
        Recommendation ra = new Recommendation("random");
        ra.addBook(new Book("rand1", "The Hunger Games", "Dystopian", 2008));
        ra.addBook(new Book("rand2", "Harry Potter", "Dystopian", 2011));
        add(ra);

        Recommendation scifi = new Recommendation("Sci-Fi");
        scifi.addBook(new Book("scifi01", "Dune", "Science Fiction", 1965));
        scifi.addBook(new Book("scifi02", "Foundation", "Science Fiction", 1951));
        scifi.addBook(new Book("scifi03", "The Three-Body Problem", "Science Fiction", 2006));
        add(scifi);

        Recommendation fantasy = new Recommendation("Fantasy");
        fantasy.addBook(new Book("fantasy0", "The Hobbit", "Fantasy", 1937));
        fantasy.addBook(new Book("fantasy1", "The Name of the Wind", "Fantasy", 2007));
        add(fantasy);
    }
}
