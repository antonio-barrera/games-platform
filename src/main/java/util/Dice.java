package util;

import java.util.Random;

public class Dice {
    public static int generateValue(int bound) {
        return new Random().nextInt(bound);
    }
}
