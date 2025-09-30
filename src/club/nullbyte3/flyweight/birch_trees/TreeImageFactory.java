package club.nullbyte3.flyweight.birch_trees;

public class TreeImageFactory {
    public static final String LEAFLESS = "leafless";
    public static final String LEAFY = "leafy";

    private final TreeImage leaflessTreeImage;
    private final TreeImage leafyTreeImage;

    public TreeImageFactory() {
        this.leaflessTreeImage = new TreeImage("L", "leafless birch");
        this.leafyTreeImage = new TreeImage("G", "leafy birch");
    }

    public TreeImage getTreeImage(String type) {
        if (LEAFY.equalsIgnoreCase(type)) {
            return leafyTreeImage;
        }
        return leaflessTreeImage;
    }
}
