package problem1;

import java.util.function.BinaryOperator;

public class Page implements Comparable<Page> {
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 400;
    private static final String ERR_PAGE_BOUND = "페이지는 1 ~ 400까지의 값입니다.";
    private final int page;

    public Page(int page) {
        this.page = page;
        validatePageBound();
    }

    private void validatePageBound() {
        if (page < LOWER_BOUND || page > UPPER_BOUND)
            throw new IllegalArgumentException(ERR_PAGE_BOUND);
    }

    public int getScore() {
        return Math.max(sumDigits(), multiplyDigits());
    }

    private int sumDigits() {
        return calculateDigits((result, digit) -> result + digit);
    }

    private int multiplyDigits() {
        return calculateDigits((result, digit) -> result * digit);
    }

    private int calculateDigits(BinaryOperator<Integer> binaryOperator) {
        return String.valueOf(page)
                .chars()
                .mapToObj(Character::getNumericValue)
                .reduce(binaryOperator)
                .orElse(-1);
    }

    public boolean isOdd() {
        return page % 2 == 1;
    }

    @Override
    public int compareTo(Page other) {
        return this.page - other.page;
    }
}
