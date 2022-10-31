package problem1;

import java.util.List;

public class Validator {
    private final List<Integer> pages;
    private final List<Integer> START_PAGE = List.of(1, 2);
    private final List<Integer> END_PAGE = List.of(399, 400);

    Validator(List<Integer> pages) {
        this.pages = pages;
    }

    public boolean validate() {
        return validateSize() &&
                validateRange() &&
                validatePage() &&
                validateNextPage() &&
                validateNotStartAndEndPage();
    }

    private boolean validateSize() {
        return pages.size() == 2;
    }

    private boolean validateRange() {
        return checkRange(pages.get(0)) && checkRange(pages.get(1));
    }

    private boolean validatePage() {
        return checkOdd(pages.get(0)) && checkEven(pages.get(1));
    }

    private boolean validateNextPage() {
        int gap = pages.get(1) - pages.get(0);
        return (gap == 1);
    }

    private boolean validateNotStartAndEndPage() {
        return !(pages.equals(START_PAGE) || pages.equals(END_PAGE));
    }

    private boolean checkRange(int page) {
        return (page >= 1) && (page <= 400);
    }

    private boolean checkEven(int page) {
        return page % 2 == 0;
    }

    private boolean checkOdd(int page) {
        return page % 2 == 1;
    }
}
