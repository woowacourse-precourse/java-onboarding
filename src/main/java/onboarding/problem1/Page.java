package onboarding.problem1;

import java.util.Arrays;
import java.util.stream.Stream;

public class Page {

    private static int findMaxPage(int pageNumber) {
        int[] singleDigitArray =
                Stream.of(String.valueOf(pageNumber).split(""))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        return Math.max(sumSingleDigit(singleDigitArray), multiplySingleDigit(singleDigitArray));
    }

    private static int sumSingleDigit(int[] singleDigitArray) {
        return Arrays
                .stream(singleDigitArray)
                .sum();
    }

    private static int multiplySingleDigit(int[] singleDigitArray) {
        return Arrays
                .stream(singleDigitArray)
                .reduce((a,b) -> a * b)
                .getAsInt();
    }
}