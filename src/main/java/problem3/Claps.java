package problem3;

import java.util.Arrays;

public class Claps {

    int[] clap;

    public Claps(int[] clap) {
        this.clap = clap;
    }

    private static int[] getDigits(int num) {
        return Arrays
                .stream(getSplit(num))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static String[] getSplit(int num) {
        return String.valueOf(num).split("");
    }
}
