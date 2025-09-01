package club.nullbyte3.state;

public class MasterState implements CharacterState {
    private final Character character;

    public MasterState(Character character) {
        this.character = character;
    }

    @Override
    public void train() {
        System.out.println("You have mastered all skills. There is nothing more to train.");
    }

    @Override
    public void meditate() {
        System.out.println("You are at peace with yourself.");
    }

    @Override
    public void fight() {
        System.out.println("You are an undefeatable master.");
    }

    @Override
    public String getLevel() {
        return "Master";
    }
}
