package game;

import player.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class Game {
    private Player player1;
    private Player player2;
    protected List<Player> results = new ArrayList<>();
    protected final int NUMBER_OF_TURNS = 2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public abstract void playRound();

    protected abstract Player[] choosePlayersRoles(Player player1, Player player2);

    protected Player[] flipTurns(Player[] players) {
        Player[] turns;
        if (players[0].equals(getPlayer1()))
            turns = new Player[] {getPlayer2(), getPlayer1()};
        else
            turns = new Player[] {getPlayer1(), getPlayer2()};
        return turns;
    }

    public void printResult() {
        System.out.println("\n......................");
        System.out.println("Results: ");
        long player1Winnings = results.stream()
                .filter(result -> result.getId() == getPlayer1().getId())
                .count();
        long player2Winnings = results.stream()
                .filter(result -> result.getId() == getPlayer2().getId())
                .count();
        if (player1Winnings > player2Winnings)
            System.out.println(getPlayer1().getName() + " won the round!");
        else if (player1Winnings < player2Winnings)
            System.out.println(getPlayer2().getName() + " won the game!");
        else
            System.out.println("It was a tie!");
        System.out.println("......................\n");
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

}
