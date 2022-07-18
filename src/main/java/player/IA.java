package player;

import game.tictactoe.Board;
import game.tictactoe.Piece;
import util.Dice;

public class IA extends Player {
    public IA(String name) {
        super(name);
    }

    @Override
    public String giveWord() {
        //String apiUrl = "https://palabras-aleatorias-public-api.herokuapp.com/random";
        return null;
    }

    @Override
    public char giveLetter() {
        String setOfCharacters = "abcdefghxyz1234567-/@";
        char randomChar = setOfCharacters.charAt(Dice.generateValue(setOfCharacters.length()));
        return randomChar;
    }

    @Override
    public int[] putPiece() {
        int row = Dice.generateValue(4);
        int column = Dice.generateValue(4);
        Piece[][] board = new Board().getBoard();
        while (row <= 0 || column <= 0 || board[row - 1][column - 1] != null) {
            row = Dice.generateValue(3);
            column = Dice.generateValue(3);
        }
        return new int[] {row, column};
    }

}
