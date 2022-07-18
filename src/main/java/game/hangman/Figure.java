package game.hangman;

public class Figure {
    private int numWrong;

    public void paintFigure() {
        System.out.println("  ____");
        System.out.println("  |  |");
        if (numWrong > 0) {
            System.out.println("  |  O");
            if (numWrong == 2) System.out.println("  |  |");
            else if (numWrong == 3) System.out.println("  | \\|");
            else if (numWrong >= 4) System.out.println("  | \\|/");
            if (numWrong == 5) System.out.println("  | /");
            else if (numWrong == 6) System.out.println("  | / \\");
        }
        for (int k = 6 - numWrong; k > 0; k--)
            System.out.println("  |");
        System.out.println("__|__");
        System.out.println();
    }

    public boolean isHanged() {
        return this.numWrong >= 6;
    }

    public void addPart() {
        this.numWrong++;
    }
}
