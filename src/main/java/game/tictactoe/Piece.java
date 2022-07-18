package game.tictactoe;

public enum Piece {
    X("X"),
    O("O"),
    Null("-");

    private final String piece;

    private Piece(String value) {
        piece = value;
    }

    @Override
    public String toString() {
        return this.piece;
    }
}
