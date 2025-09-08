package club.nullbyte3.template;

import java.util.Random;

public class DiceGame extends Game {
    private int[] scores;
    private final Random random = new Random();
    private static final int WINNING_SCORE = 20;
    private int winner;
    private boolean isGameOver = false;

    @Override
    public void initializeGame(int numberOfPlayers) {
        scores = new int[numberOfPlayers];
        System.out.println("Game started with " + numberOfPlayers + " players. First to " + WINNING_SCORE + " wins!");
    }

    @Override
    public boolean endOfGame() {
        return isGameOver;
    }

    @Override
    public void playSingleTurn(int player) {
        int roll = random.nextInt(6) + 1;
        scores[player] += roll;
        System.out.println("Player " + (player + 1) + " rolled a " + roll + ". Total score: " + scores[player]);

        if (scores[player] >= WINNING_SCORE) {
            winner = player;
            isGameOver = true;
        }
    }

    @Override
    public void displayWinner() {
        System.out.println("Player " + (winner + 1) + " wins with a score of " + scores[winner] + "!");
    }
}
