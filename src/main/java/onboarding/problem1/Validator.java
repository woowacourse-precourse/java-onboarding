package onboarding.problem1;

import java.util.List;

public class Validator {
    private static final int START_PAGE = 1;
    private static final int END_PAGE = 400;

    public static boolean validate(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        if (!(isInRange(leftPage) && isInRange(rightPage))) {return false;}

        if (!((leftPage % 2 == 1 ) && ( rightPage % 2 == 0))) {return false;}

        if (leftPage - rightPage != -1) {return false;}

        return true;
    }
    public static boolean isInRange(int page) {
        return (page >= START_PAGE) && (page <= END_PAGE);
    }
}
