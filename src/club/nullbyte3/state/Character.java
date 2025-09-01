package club.nullbyte3.state;

public class Character {
    private String name;
    private int experiencePoints;
    private int healthPoints;
    private CharacterState state;

    public Character(String name) {
        this.name = name;
        this.experiencePoints = 0;
        this.healthPoints = 100;
        this.state = new NoviceState(this);
    }

    public void train() {
        state.train();
    }

    public void meditate() {
        state.meditate();
    }

    public void fight() {
        state.fight();
    }

    public void displayStatus() {
        System.out.println("----- Statistics -----");
        System.out.println("Name: " + name);
        System.out.println("Level: " + state.getLevel());
        System.out.println("Experience: " + experiencePoints);
        System.out.println("Health: " + healthPoints);
        System.out.println("------------------------");
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void addExperiencePoints(int points) {
        this.experiencePoints += points;
        System.out.println("got " + points + " exp points.");
    }

    public void addHealthPoints(int points) {
        this.healthPoints += points;
        System.out.println("got " + points + " hp.");
    }

    public void takeDamage(int damage) {
        this.healthPoints -= damage;
        System.out.println("took " + damage + " damage.");
    }

    public void setState(CharacterState state) {
        this.state = state;
        System.out.println("GG! leveled up to " + state.getLevel() + " level!");
    }

    public CharacterState getState() {
        return state;
    }
}
