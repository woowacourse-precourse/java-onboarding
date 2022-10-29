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

    private static int getClapCount(int[] digits) {
        int count = 0;
        for (int digit : digits) {
            count = addCount(count, digit);
        }
        return count;
    }

    private static int addCount(int count, int num) {
        if (isClap(num))
            count += 1;
        return count;
    }

    private static boolean isClap(int num) {
        return num == 3 || num == 6 || num == 9;
    }
}
