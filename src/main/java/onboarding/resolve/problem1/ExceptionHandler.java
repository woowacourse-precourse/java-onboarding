package onboarding.resolve.problem1;

import java.util.List;
import java.util.regex.Pattern;

public class ExceptionHandler {

    public static boolean validateInput(List<Integer> input) {
        if (firstPageOrLastPage(input)) {
            return false;
        }
        if (oddAndEvenChk(input)) {
            return false;
        }
        if (rightMinusLeftNotOne(input)) {
            return false;
        }
        return !Not1To400(input);
    }

    private static boolean Not1To400(List<Integer> input) {
        return input.get(0) >= 1 && input.get(1) <= 400;
    }

    private static boolean rightMinusLeftNotOne(List<Integer> input) {
        return input.get(1) - input.get(0) != 1;

    }

    private static boolean oddAndEvenChk(List<Integer> input) {
        return input.get(0) % 2 != 1 || input.get(1) % 2 != 0;
    }


    private static boolean firstPageOrLastPage(List<Integer> input) {
        return input.get(0) == 1 || input.get(1) == 400;
    }


}
