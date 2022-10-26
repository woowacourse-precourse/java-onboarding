package onboarding.feature1;

import static onboarding.feature1.Constants.*;

public class PageValidator {
    public static boolean isValid (PageNumber pageNumber) {
        if (!isConsecutive(pageNumber) || isFirstOrLast(pageNumber)) {
            return false;
        }
        return true;
    }
    public static boolean isConsecutive (PageNumber pageNumber) {
        if (pageNumber.getRightPage() - pageNumber.getLeftPage() == 1) {
            return true;
        }
        return false;
    }

    public static boolean isFirstOrLast(PageNumber pageNumber) {
        if (pageNumber.getLeftPage() == FIRST_PAGE || pageNumber.getLeftPage() == LAST_PAGE) {
            return false;
        }
        return true;
    }
}
