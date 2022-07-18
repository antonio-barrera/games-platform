package game.hangman;

import game.Turn;
import player.Player;

public class HangmanTurn extends Turn {
    private Word word;
    private Figure figure;
    public HangmanTurn(Player giver, Player guesser) {
        super(giver, guesser);
        this.figure = new Figure();
    }

    @Override
    public void play() {
        String givenWord = getPlayer1().giveWord();
        word = new Word(givenWord);
        figure.paintFigure();
        word.writeWord();
        while (!word.isGuessed() && !figure.isHanged()) {
            char givenLetter = getPlayer2().giveLetter();
            if (!word.addLetter(givenLetter)) {
                figure.addPart();
            }
            figure.paintFigure();
            word.writeWord();
            System.out.println();
        }
        if (word.isGuessed())
            setResult(getPlayer2());
        else
            setResult(getPlayer1());
    }

}
