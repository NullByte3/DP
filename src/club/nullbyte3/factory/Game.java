package club.nullbyte3.factory;

import club.nullbyte3.factory.map.Map;
import club.nullbyte3.factory.map.CityMap;
import club.nullbyte3.factory.map.WildernessMap;

public class Game {
    public static Map createMap(String type, int width, int height) {
        return switch (type.toLowerCase()) {
            case "city" -> new CityMap(width, height);
            case "wilderness" -> new WildernessMap(width, height);
            default -> throw new IllegalArgumentException("Unknown map type: " + type);
        };
    }

    public static void main(String[] args) {
        Map cityMap = createMap("city", 10, 5);
        System.out.println("City Map:");
        cityMap.display();

        System.out.println("\nWilderness Map:");
        Map wildernessMap = createMap("wilderness", 10, 5);
        wildernessMap.display();
    }
}
