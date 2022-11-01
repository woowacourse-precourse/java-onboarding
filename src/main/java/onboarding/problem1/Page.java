package onboarding.problem1;

public class Page {
    private static final int START_PAGE = 1;
    private static final int END_PAGE = 400;

    private int pageNumber;

    public Page(int pageNumber) {
        validatePageNumberRange(pageNumber);
        this.pageNumber = pageNumber;
    }

    private void validatePageNumberRange(int pageNumber) {
        if (pageNumber <= START_PAGE || pageNumber >= END_PAGE) {
            throw new IllegalArgumentException();
        }
    }

    public int getSumOfPageDigits() {
        int result = 0;
        while (pageNumber > 0) {
            result += pageNumber % 10;
            pageNumber /= 10;
        }
        return result;
    }

    public int getProductOfPageDigits() {
        int result = 1;
        while (pageNumber > 0) {
            result *= pageNumber % 10;
            pageNumber /= 10;
        }
        return result;
    }
}
