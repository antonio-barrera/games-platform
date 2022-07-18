package game.tictactoe;

import game.Turn;
import player.Player;

public class TicTacToeTurn extends Turn {
    private Board board;

    public TicTacToeTurn(Player playerX, Player playerO) {
        super(playerX, playerO);
        this.board = new Board();
    }

    @Override
    public void play() {
        Player current = getPlayer1();
        this.getPlayer1().setPiece(Piece.X);
        this.getPlayer2().setPiece(Piece.O);
        board.initBoard();
        board.paintBoard();
        while (board.isAnyAvailableSquare() && board.getWinner() == Piece.Null) {
            int[] position = current.putPiece();
            String move = "Invalid move! Try again.";
            if (board.putPiece(position[0], position[1], current.getPiece())) {
                move = current.getName() + " moved to (" + position[0] + ", " + position[1] + ")";
                current = (current.equals(getPlayer1())) ? getPlayer2() : getPlayer1();
            }
            System.out.println(move);
            board.paintBoard();
        }
        if (board.getWinner() != Piece.Null) {
            current = (current.equals(getPlayer1())) ? getPlayer2() : getPlayer1();
            setResult(current);
        }
    }

}
