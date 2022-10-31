package onboarding.problem1;

import java.util.List;

public class PageValidator {

    private static final int START_PAGE = 1;
    private static final int END_PAGE = 400;

    private static final List<List<Integer>> excludedPages = List.of(
            List.of(START_PAGE, START_PAGE + 1),
            List.of(END_PAGE - 1, END_PAGE)
    );

    public void validatePages(List<Integer> pages) {
        if (isInvalidPageNumbers(pages)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isInvalidPageNumbers(List<Integer> pages) {
        return isInvalidPageScope(pages) ||
                isNotSequenceNumber(pages) ||
                isExcludedPages(pages) ||
                isNotLeftOddRightEven(pages);
    }

    private boolean isNotSequenceNumber(List<Integer> pages) {
        return pages.get(0) + 1 != pages.get(1);
    }

    private boolean isNotLeftOddRightEven(List<Integer> pages) {
        return !(pages.get(0) % 2 == 1 && pages.get(1) % 2 == 0);
    }

    private boolean isInvalidPageScope(Integer page) {
        return !(START_PAGE <= page && page <= END_PAGE);
    }

    private boolean isInvalidPageScope(List<Integer> pages) {
        return isInvalidPageScope(pages.get(0)) || isInvalidPageScope(pages.get(1));
    }

    private boolean isExcludedPages(List<Integer> pages) {
        return excludedPages.stream().anyMatch(excludedPages -> excludedPages.equals(pages));
    }
}
