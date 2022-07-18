package game.tictactoe;

import java.util.Arrays;

public class Board {
    private int availableSquares = 9;
    private Piece[][] squares;

    public Board() {
        squares = new Piece[3][3];
    }

    public void initBoard() {
        for (Piece[] square : squares) {
            Arrays.fill(square, Piece.Null);
        }
    }

    public void paintBoard() {
        for (Piece[] square : squares) {
            System.out.println("-------------");
            System.out.println("| " + square[0] + " | " + square[1] + " | " + square[2] + " |");
        }
        System.out.println("-------------\n");
    }

    public boolean isAnyAvailableSquare() {
        return availableSquares > 0;
    }

    public boolean putPiece(int row, int column, Piece piece) {
        if (row > 3 || column > 3) return false;
        if (row <= 0 || column <= 0) return false;
        if (squares[row - 1][column - 1] == Piece.Null) {
            squares[row - 1][column - 1] = piece;
            availableSquares--;
            return true;
        }
        return false;
    }

    public Piece[][] getBoard() {
        return this.squares;
    }

    public Piece getWinner() {
        if (checkRows() != Piece.Null)
            return checkRows();
        if (checkColumns() != Piece.Null)
            return checkColumns();
        if (checkDiagonals() != Piece.Null)
            return checkDiagonals();
        return Piece.Null;
    }

    private Piece checkRows() {
        Piece piece = Piece.Null;
        for (Piece[] row : squares) {
            if (row[0] == row[1] && row[0] == row[2]) {
                piece = row[0];
                break;
            }
        }
        return piece;
    }

    private Piece checkColumns() {
        Piece piece = Piece.Null;
        for (int i = 0; i < 3; i++) {
            if (squares[0][i] == squares[1][i] && squares[0][i] == squares[2][i]) {
                piece = squares[0][i];
                break;
            }
        }
        return piece;
    }

    private Piece checkDiagonals() {
        Piece piece = Piece.Null;
        if ((squares[0][0] == squares[1][1] && squares[0][0] == squares[2][2])
                || squares[0][2] == squares[1][1] && squares[0][2] == squares[2][0])
            piece = squares[1][1];
        return piece;
    }
}
