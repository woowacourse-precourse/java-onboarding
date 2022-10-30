package onboarding.problem1;

import java.util.Arrays;

public class Page {

    private final int MIN_PAGE = 2;
    private final int MAX_PAGE = 399;

    private int number;

    public Page(int number) {
        validatePageNumber(number);
        this.number = number;
    }

    private void validatePageNumber(int number) {
        if (isOutOfBounds(number)) throw new IllegalArgumentException("Page number is out of bound");
    }

    private boolean isOutOfBounds(int number) {
        return number < MIN_PAGE || number > MAX_PAGE;
    }

    public boolean isOdd() {
        return number % 2 == 1;
    }

    public boolean isEven() {
        return number % 2 == 0;
    }

    public boolean isNextPageOf(Page previousPage) {
        return this.number - previousPage.number == 1;
    }

    public int getSum() {
        return Arrays.stream(String.valueOf(number).split(""))
                .mapToInt(Integer::parseInt)
                .sum();

    }

    public int getProduct() {
        return Arrays.stream(String.valueOf(number).split(""))
                .mapToInt(Integer::parseInt)
                .reduce(1, (v1, v2) -> v1 * v2);
    }

}
