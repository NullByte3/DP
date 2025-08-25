package club.nullbyte3.factory.tile;

public class WaterTile extends Tile {
    @Override
    public char getCharacter() {
        return 'W';
    }

    @Override
    public String getDescription() {
        return "water";
    }

    @Override
    public void action() {
        System.out.println("Swimming in water...");
    }
}
