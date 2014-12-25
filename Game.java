import java.util.Random;
import java.util.Scanner;

public class Game {

    private int computerScore;
    private int playerScore;
    private int numGames;

    public enum Choice {
        ROCK, PAPER, SCISSORS
    }

    public Choice playerChoice() {
        Character playerChoice;
        Scanner playerInput = new Scanner(System.in);
        System.out.println("Enter \"r\" for rock, \"p\" for paper, or \"s\" for scissor");
        playerChoice = playerInput.next().charAt(0);
        switch(playerChoice) {
            case 'r': return Choice.ROCK;
            case 'p' : return Choice.PAPER;
            case 's' : return Choice.SCISSORS;
        }
        return playerChoice();
    }

    public Choice computerChoice() {
        Random random = new Random();
        int computerChoice = random.nextInt(3);
        switch (computerChoice) {
            case 0: return Choice.ROCK;
            case 1: return Choice.PAPER;
            case 2: return Choice.SCISSORS;
        }
        return null;
    }

    public int compare(Choice player, Choice computer) {
        if (player.equals(computer)) return 0;
        switch (player) {
            case ROCK: return(computer == Choice.SCISSORS ? 1 : -1);
            case SCISSORS: return(computer == Choice.PAPER ? 1 : -1);
            case PAPER: return(computer == Choice.ROCK ? 1 : -1);
        }
        return 0;
    }

    public void result(int result) {
        switch (result) {
            case -1:
                System.out.println("Sorry, you lose.");
                computerScore++;
                break;
            case 0:
                System.out.println("Tie!");
                break;
            case 1:
                System.out.println("You win!");
                playerScore++;
                break;
        }
        numGames++;
        int ties = numGames - (playerScore + computerScore);
        // Calculate to 3 decimal places
        double percentage = (double)Math.round((playerScore + 0.5*ties) / numGames * 1000) / 1000;
        System.out.println("Wins: " + playerScore + " Losses: " + computerScore + " Ties: " + ties +
                " Wins Percentage: " + percentage);
    }

    public Character playAgain() {
        Scanner scan = new Scanner(System.in);
        Character playAgain;
        do {
            System.out.println("Play again (y/n)?");
            playAgain = scan.next().charAt(0);
        } while(!playAgain.equals('y') && !playAgain.equals('n'));
        return playAgain;
    }

}
