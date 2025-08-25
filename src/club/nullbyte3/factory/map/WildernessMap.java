package club.nullbyte3.factory.map;

import club.nullbyte3.factory.tile.*;
import java.util.Random;

public class WildernessMap extends Map {
    private final static Random random = new Random();

    public WildernessMap(int width, int height) {
        super(width, height);
    }

    @Override
    protected Tile createTile() {
        return switch (random.nextInt(3)) {
            case 0 -> new SwampTile();
            case 1 -> new WaterTile();
            case 2 -> new ForestTile();
            default -> throw new IllegalStateException("Unexpected value");
        };
    }
}
