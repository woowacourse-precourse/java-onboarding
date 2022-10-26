package onboarding.feature1;

import static onboarding.feature1.Constants.*;

public class PageValidator {
    public static boolean isConsecutive (Integer leftPage, Integer rightPage) {
        if (rightPage - leftPage == 1) {
            return true;
        }
        return false;
    }

    public static boolean isFirstOrLast(Integer leftPage) {
        if (leftPage == FIRST_PAGE || leftPage == LAST_PAGE) {
            return false;
        }
        return true;
    }
}
