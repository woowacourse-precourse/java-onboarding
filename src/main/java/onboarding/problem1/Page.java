package onboarding.problem1;

import java.util.List;
import java.util.stream.Collectors;

public class Page {

    private static final int FIRST_PAGE = 1;
    private static final int LAST_PAGE = 400;

    private final Integer page;

    public Page(final Integer page) {
        this.page = page;
    }

    public boolean isValidLeftPage() {
        return isValidPage()
            && page % 2 == 1;
    }

    public boolean isValidRightPage() {
        return isValidPage()
            && page % 2 == 0;
    }

    private boolean isValidPage() {
        return page >= FIRST_PAGE
            && page <= LAST_PAGE;
    }

    public boolean isPlacedRightAfter(final Page leftExpectedPage) {
        return page == leftExpectedPage.getPage() + 1;
    }

    public int findMaxValue() {

        List<Integer> digits = parseToDigits(page);

        return Math.max(
            calculateSumOf(digits),
            calculateMultiplyOf(digits)
        );
    }

    private List<Integer> parseToDigits(final Integer number) {

        return String.valueOf(number)
            .chars()
            .map(it -> (char)it)
            .map(Character::getNumericValue)
            .boxed()
            .collect(Collectors.toList());
    }

    private int calculateSumOf(final List<Integer> digits) {
        return digits.stream()
            .reduce(0, Integer::sum);
    }

    private int calculateMultiplyOf(final List<Integer> digits) {
        return digits.stream()
            .reduce(1, (a, b) -> a * b);
    }

    private Integer getPage() {
        return page;
    }
}
