package problem3;

import java.util.Arrays;

public class Claps {

    private int[] clap;

    public Claps(int[] clap) {
        this.clap = clap;
    }

    public int clap() {
        int length = clap.length;
        for (int i = 2; i < length; i++) {
            int[] digits = getDigits(i);
            clap[i] = clap[i - 1] + getClapCount(digits);
        }
        return clap[length-1];
    }

    private int[] getDigits(int num) {
        return Arrays
                .stream(getSplit(num))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private String[] getSplit(int num) {
        return String.valueOf(num).split("");
    }

    private int getClapCount(int[] digits) {
        int count = 0;
        for (int digit : digits) {
            count = addCount(count, digit);
        }
        return count;
    }

    private int addCount(int count, int num) {
        if (isClap(num))
            count += 1;
        return count;
    }

    private boolean isClap(int num) {
        return num == 3 || num == 6 || num == 9;
    }
}
