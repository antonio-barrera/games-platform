package player;

import game.tictactoe.Piece;
import util.Dice;

import java.util.Objects;

public abstract class Player {
    private int id;
    private String name;
    private int winnings;
    private int losses;
    private int rounds;
    private Piece piece;

    public Player(String name) {
        this.name = name;
        this.winnings = 0;
        this.losses = 0;
        this.rounds = 0;
    }

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        this.winnings = 0;
        this.losses = 0;
        this.rounds = 0;
    }

    public int throwDice() {
        return Dice.generateValue(100);
    }

    public abstract String giveWord();

    public abstract char giveLetter();

    public abstract int[] putPiece();

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWinnings() {
        return winnings;
    }

    public void setWinnings(int winnings) {
        this.winnings = winnings;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof Player)) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(this.name, player.name) && Objects.equals(this.winnings, player.winnings)
                && Objects.equals(this.losses, player.losses) && Objects.equals(this.rounds, player.rounds)
                && Objects.equals(this.piece, player.piece);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.winnings, this.losses, this.rounds, this.piece);
    }

    @Override
    public String toString() {
        return          name +
                " - " + winnings +
                " - " + losses +
                " - " + rounds;
    }
}
