package game.hangman;

import java.util.Arrays;

public class Word {
    private final char[] givenWord;
    private final char[] guessedWord;

    public Word(String givenWord) {
        this.givenWord = givenWord.toCharArray();
        this.guessedWord = new char[givenWord.length()];
    }

    public void writeWord() {
        for (char letter : guessedWord)
            System.out.print(letter + " ");
        System.out.println();
        for (char letter : guessedWord)
            System.out.print("_ ");
        System.out.println();
    }

    public boolean isGuessed() {
        return Arrays.equals(guessedWord, givenWord);
    }

    public boolean addLetter(char letter) {
        for (int i = 0; i < givenWord.length; i++) {
            if (letter == givenWord[i]) {
                guessedWord[i] = letter;
                return true;
            }
        }
        return false;
    }

}
