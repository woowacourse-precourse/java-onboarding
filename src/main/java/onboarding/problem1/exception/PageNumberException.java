package onboarding.problem1.exception;

import java.util.List;

import static onboarding.problem1.constance.Constance.*;
import static onboarding.problem1.constance.Constance.LAST_PAGE_NUMBER;

public class PageNumberException {
    private PageNumberException() {}

    public static int validates(List<Integer> user) {
        int leftPageNumber = user.get(0);
        int rightPageNumber = user.get(1);
        if (!isPageOdd(leftPageNumber) ||
                isPageOdd(rightPageNumber) ||
                isFirstPage(leftPageNumber) ||
                isEndPage(rightPageNumber) ||
                isPageSizeLackOrOverflow(leftPageNumber) ||
                isPageSizeLackOrOverflow(rightPageNumber) ||
                !isPageContinue(leftPageNumber, rightPageNumber)) {
            return EXCEPTION_MESSAGE;
        }

        return 0;
    }

    private static boolean isPageOdd(int pageNumber) {
        return pageNumber % 2 != 0;
    }

    private static boolean isFirstPage(int pageNumber) {
        return pageNumber == START_PAGE_NUMBER || pageNumber == START_PAGE_NUMBER + 1;
    }

    private static boolean isEndPage(int pageNumber) {
        return pageNumber == LAST_PAGE_NUMBER - 1 || pageNumber == LAST_PAGE_NUMBER;
    }

    private static boolean isPageSizeLackOrOverflow(int pageNumber) {
        return pageNumber < START_PAGE_NUMBER || pageNumber > LAST_PAGE_NUMBER;
    }

    private static boolean isPageContinue(int leftPageNumber, int rightPageNumber) {
        return leftPageNumber + 1 == rightPageNumber;
    }
}
