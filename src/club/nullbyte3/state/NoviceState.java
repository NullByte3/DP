package club.nullbyte3.state;

public class NoviceState implements CharacterState {
    private final Character character;

    public NoviceState(Character character) {
        this.character = character;
    }

    @Override
    public void train() {
        character.addExperiencePoints(10);
        if (character.getExperiencePoints() >= 20) {
            character.setState(new IntermediateState(character));
        }
    }

    @Override
    public void meditate() {
        System.out.println("You are not experienced enough to meditate.");
    }

    @Override
    public void fight() {
        System.out.println("You are not experienced enough to fight.");
    }

    @Override
    public String getLevel() {
        return "Novice";
    }
}
