package club.nullbyte3.flyweight.birch_trees;

public final class TreeImage implements Flyweight {
    private final String image;
    private final String description;

    public TreeImage(String image, String description) {
        this.image = image;
        this.description = description;
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
