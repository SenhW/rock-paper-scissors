public class RockPaperScissors {

    public static void main(String[] args) {
        Game game = new Game();
        while (true) {
            Game.Choice playerChoice = game.playerChoice();
            Game.Choice computerChoice = game.computerChoice();
            System.out.println("You chose " + playerChoice);
            System.out.println("Computer chose " + computerChoice);
            int result = game.compare(playerChoice, computerChoice);
            game.result(result);
            Character playAgain = game.playAgain();
            if(playAgain.equals('y')) {
                System.out.println();
            } else {
                break;
            }
        }
        System.out.println("Thanks for playing!");
    }
}
