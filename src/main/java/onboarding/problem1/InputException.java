package onboarding.problem1;

import java.util.List;

public class InputException {

    private static final int VALID_LENGTH = 2;
    public static final int VALID_DIFFERENCE = 1;
    public static final int VALID_MIN_RANGE = 3;
    public static final int VALID_MAX_RANGE = 398;

    public static boolean hasValidLength(List<Integer> pages) {
        return pages.size() == VALID_LENGTH;
    }

    public static boolean hasValidNum(List<Integer> pages) {
        return pages.get(0) % 2 == 1 && pages.get(1) % 2 == 0;
    }

    public static boolean hasValidRange(List<Integer> pages) {
        for (int page : pages) {
            if (page > VALID_MAX_RANGE || page < VALID_MIN_RANGE) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasValidDifference(List<Integer> pages) {
        return pages.get(1) - pages.get(0) == VALID_DIFFERENCE;
    }

    public static boolean validationCheck(List<Integer> pages) {
        return hasValidLength(pages) && hasValidNum(pages) && hasValidDifference(pages) && hasValidRange(pages);
    }
}
