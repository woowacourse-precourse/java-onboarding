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
        int number = this.pageNumber;
        while (number > 0) {
            result += Math.floorMod(number, 10);
            number = Math.floorDiv(number, 10);
        }
        return result;
    }

    public int getProductOfPageDigits() {
        int result = 1;
        int number = this.pageNumber;
        while (number > 0) {
            result *= Math.floorMod(number, 10);
            number = Math.floorDiv(number, 10);
        }
        return result;
    }

    public int getPageNumber() {
        return pageNumber;
    }
}
