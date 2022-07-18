package game.tictactoe;

import game.Game;
import player.Player;
import util.Dice;

public class TicTacToe extends Game {
    private TicTacToeTurn turn;

    public TicTacToe(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public void playRound() {
        System.out.println("\nWelcome to TicTacToe!\n");
        Player[] roles = choosePlayersRoles(getPlayer1(), getPlayer2());
        for (int i = 0; i < NUMBER_OF_TURNS; i++) {
            System.out.println("Preparing a new turn...\n");
            System.out.println("Player X: " + roles[0].getName());
            System.out.println("Player O: " + roles[1].getName());
            turn = new TicTacToeTurn(roles[0], roles[1]);
            turn.play();
            if (turn.getResult() != null) {
                results.add(turn.getResult());
            }
            roles = flipTurns(roles);
        }
    }

    @Override
    protected Player[] choosePlayersRoles(Player playerX, Player playerO) {
        Player[] roles;
        if (Dice.generateValue(100) < 50)
            roles = new Player[] {playerX, playerO};
        else
            roles = new Player[] {playerO, playerX};
        return roles;
    }

}
