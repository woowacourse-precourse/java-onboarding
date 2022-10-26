package onboarding.feature1;

import static onboarding.feature1.Constants.*;

public class PageValidator {
    public static boolean isConsecutive (int leftPage, int rightPage) {
        if (rightPage - leftPage == 1) {
            return true;
        }
        return false;
    }

    public static boolean isFirstOrLast(int leftPage) {
        if (leftPage == FIRST_PAGE || leftPage == LAST_PAGE) {
            return false;
        }
        return true;
    }
}
