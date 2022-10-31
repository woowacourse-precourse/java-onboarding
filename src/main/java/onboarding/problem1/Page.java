package onboarding.problem1;

import java.util.Arrays;

public class Page {

    private static int sumSingleDigit(int[] singleDigitArray) {
        return Arrays
                .stream(singleDigitArray)
                .sum();
    }
}