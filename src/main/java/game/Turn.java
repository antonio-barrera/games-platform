package game;

import player.Player;

public abstract class Turn {
    private Player player1;
    private Player player2;
    private Player result;

    public Turn(Player player1, Player player2) {
        this.result = null;
        this.player1 = player1;
        this.player2 = player2;
    }

    public abstract void play();

    public void setResult(Player player) {
        player.setWinnings(player.getWinnings() + 1);
        if (player.equals(player1))
            player2.setLosses(player2.getLosses() + 1);
        else if (player.equals(player2))
            player1.setLosses(player1.getLosses() + 1);
        result = player;
        player1.setRounds(player1.getRounds() + 1);
        player2.setRounds(player2.getRounds() + 1);
    }

    public Player getResult() {
        return this.result;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }
}
