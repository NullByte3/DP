package club.nullbyte3.factory.map;

import club.nullbyte3.factory.tile.*;
import java.util.Random;

public class CityMap extends Map {
    private static final Random random = new Random();

    public CityMap(int width, int height) {
        super(width, height);
    }

    @Override
    protected Tile createTile() {
        return switch (random.nextInt(3)) {
            case 0 -> new RoadTile();
            case 1 -> new ForestTile();
            case 2 -> new BuildingTile();
            default -> throw new IllegalStateException("Unexpected value");
        };
    }
}
