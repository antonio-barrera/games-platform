package game.hangman;

import game.Game;
import game.tictactoe.TicTacToeTurn;
import player.Player;

import java.util.Arrays;

public class Hangman extends Game {
    private HangmanTurn turn;

    public Hangman(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public void playRound() {
        System.out.println("\nWelcome to Hangman!\n");
        Player[] roles = choosePlayersRoles(getPlayer1(), getPlayer2());
        for (int i = 0; i < NUMBER_OF_TURNS; i++) {
            System.out.println("Preparing a new turn...\n");
            System.out.println("Giver: " + roles[0].getName());
            System.out.println("Guesser: " + roles[1].getName());
            turn = new HangmanTurn(roles[0], roles[1]);
            turn.play();
            if (turn.getResult() != null) {
                results.add(turn.getResult());
            }
            roles = flipTurns(roles);
        }
    }

    @Override
    protected Player[] choosePlayersRoles(Player player1, Player player2) {
        int[] player1Values = new int[NUMBER_OF_TURNS];
        int[] player2Values = new int[NUMBER_OF_TURNS];
        for (int i = 0; i < NUMBER_OF_TURNS; i++) {
            player1Values[i] = player1.throwDice();
            player2Values[i] = player2.throwDice();
        }
        if (Arrays.stream(player1Values).max().getAsInt() > Arrays.stream(player2Values).max().getAsInt())
            return new Player[] {player1, player2};
        return new Player[] {player2, player1};
    }

}
