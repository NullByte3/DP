package club.nullbyte3.state;

public class IntermediateState implements CharacterState {
    private final Character character;

    public IntermediateState(Character character) {
        this.character = character;
    }

    @Override
    public void train() {
        character.addExperiencePoints(10);
        if (character.getExperiencePoints() >= 50) {
            character.setState(new ExpertState(character));
        }
    }

    @Override
    public void meditate() {
        character.addHealthPoints(10);
    }

    @Override
    public void fight() {
        System.out.println("You are not experienced enough to fight.");
    }

    @Override
    public String getLevel() {
        return "Intermediate";
    }
}
