package onboarding.feature1;

import static onboarding.feature1.Constants.*;

public class PageValidator {
    public static boolean isValid (Pages pages) {
        if (!isConsecutive(pages) || isFirstOrLast(pages)) {
            return false;
        }
        return true;
    }
    public static boolean isConsecutive (Pages pages) {
        if (pages.getRightPage() - pages.getLeftPage() == 1) {
            return true;
        }
        return false;
    }

    public static boolean isFirstOrLast(Pages pages) {
        if (pages.getLeftPage() == FIRST_PAGE || pages.getLeftPage() == LAST_PAGE) {
            return true;
        }
        return false;
    }
}
