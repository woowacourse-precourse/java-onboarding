package onboarding.problem1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Page {

    public static int getMyMaxPage(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        return Math.max(findMaxPage(leftPage), findMaxPage(rightPage));
    }

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