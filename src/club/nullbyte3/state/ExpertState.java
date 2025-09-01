package club.nullbyte3.state;

public class ExpertState implements CharacterState {
    private final Character character;

    public ExpertState(Character character) {
        this.character = character;
    }

    @Override
    public void train() {
        character.addExperiencePoints(10);
        if (character.getExperiencePoints() >= 100) {
            character.setState(new MasterState(character));
        }
    }

    @Override
    public void meditate() {
        character.addHealthPoints(10);
    }

    @Override
    public void fight() {
        character.addExperiencePoints(15);
        character.takeDamage(5);
        if (character.getExperiencePoints() >= 100) {
            character.setState(new MasterState(character));
        }
    }

    @Override
    public String getLevel() {
        return "Expert";
    }
}
