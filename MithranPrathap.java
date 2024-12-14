import java.util.*;

public class MithranPrathap implements Player {
    private static String name = "6MithranPrathap";
    private Random random = new Random();

    /**
     * Analyzes the opponent's moves and adapts a strategy to counter their most frequent move.
     * 
     * @param myMoves       Array of player's moves
     * @param opponentMoves Array of opponent's moves
     * @param myScore       Player's current score
     * @param opponentScore Opponent's current score
     * @return              "r" for Rock, "p" for Paper, "s" for Scissors
     */
    public String move(String[] myMoves, String[] opponentMoves, int myScore, int opponentScore) {
    // Handle null or empty arrays
    if (opponentMoves == null || opponentMoves.length == 0) {
        return randomMove(); // Choose a random move for the first round
    }

    // Initialize counters for opponent's moves
    int rockCount = 0, paperCount = 0, scissorsCount = 0;

    // Count occurrences of each move
    for (String move : opponentMoves) {
        if ("r".equals(move)) rockCount++;
        else if ("p".equals(move)) paperCount++;
        else if ("s".equals(move)) scissorsCount++;
    }

    // Determine the most frequent move and counter it
    String mostFrequentMove = "r";
    if (paperCount > rockCount && paperCount > scissorsCount) {
        mostFrequentMove = "p";
    } else if (scissorsCount > rockCount && scissorsCount > paperCount) {
        mostFrequentMove = "s";
    }

    // Counter the most frequent move
    String counterMove;
    if (mostFrequentMove.equals("r")) {
        counterMove = "p"; // Paper beats Rock
    } else if (mostFrequentMove.equals("p")) {
        counterMove = "s"; // Scissors beats Paper
    } else {
        counterMove = "r"; // Rock beats Scissors
    }

    // Randomize 20% of the time
    if (random.nextDouble() < 0.2) {
        return randomMove();
    }

    return counterMove;
}


    /**
     * Generates a random move.
     * 
     * @return "r" for Rock, "p" for Paper, "s" for Scissors
     */
    private String randomMove() {
        int choice = random.nextInt(3);
        switch (choice) {
            case 0:
                return "r";
            case 1:
                return "p";
            default:
                return "s";
        }
    }

    /**
     * Returns the name of the player.
     * 
     * @return The name of the player.
     */
    public String getName() {
        return name;
    }
}
