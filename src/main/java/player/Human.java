package player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Human extends Player {
    private final Scanner sn = new Scanner(System.in);

    public Human(String name) {
        super(name);
    }

    @Override
    public String giveWord() {
        System.out.println("Enter a word to guess: ");
        return sn.nextLine();
    }

    @Override
    public char giveLetter() {
        System.out.println("Enter a letter: ");
        char letter = sn.next().charAt(0);
        sn.nextLine();
        return letter;
    }

    @Override
    public int[] putPiece() {
        int[] position = null;
        try {
            System.out.println("Enter the row position: ");
            int row = sn.nextInt();
            System.out.println("Enter the column position: ");
            int column = sn.nextInt();
            sn.nextLine();
            position = new int[] {row, column};
        } catch (InputMismatchException e) {
            System.out.println("You have to enter a number.");
            sn.next();
        }
        return position;
    }

}
