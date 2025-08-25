package club.nullbyte3.factory.tile;

public class RoadTile extends Tile {
    @Override
    public char getCharacter() {
        return 'R';
    }

    @Override
    public String getDescription() {
        return "road";
    }

    @Override
    public void action() {
        System.out.println("Walking on road...");
    }
}
