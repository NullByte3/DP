package club.nullbyte3.factory.tile;

public class ForestTile extends Tile {
    @Override
    public char getCharacter() {
        return 'F';
    }

    @Override
    public String getDescription() {
        return "forest";
    }

    @Override
    public void action() {
        System.out.println("Walking through forest...");
    }
}
