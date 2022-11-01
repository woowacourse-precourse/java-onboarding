package onboarding.problem1;

public class Page {
    private static final int START_PAGE = 1;
    private static final int END_PAGE = 400;

    private int pageNumber;

    public Page(int pageNumber) {
        validatePageNumberRange(pageNumber);
        this.pageNumber = pageNumber;
    }

    private static void validatePageNumberRange(int pageNumber) {
        if (pageNumber <= START_PAGE || pageNumber >= END_PAGE) {
            throw new IllegalArgumentException();
        }
    }
}
