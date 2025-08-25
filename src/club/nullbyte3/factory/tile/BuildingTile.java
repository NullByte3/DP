package club.nullbyte3.factory.tile;

public class BuildingTile extends Tile {
    @Override
    public char getCharacter() {
        return 'B';
    }

    @Override
    public String getDescription() {
        return "building";
    }

    @Override
    public void action() {
        System.out.println("Entering building...");
    }
}
