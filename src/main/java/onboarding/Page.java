package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Page {

    private static final int FIRST_PAGE = 1;
    private static final int LAST_PAGE = 400;

    private final Integer page;

    public Page(final Integer page) {
        this.page = page;
    }

    public boolean isValidPage() {
        return page >= FIRST_PAGE
            && page <= LAST_PAGE;
    }

    public boolean isRightSidePairOf(final Page leftExpectedPage) {
        return isRightPage()
            && leftExpectedPage.isLeftPage()
            && isAfter(leftExpectedPage)
            && isConnectedTo(leftExpectedPage);
    }

    private boolean isRightPage() {
        return page % 2 == 0;
    }

    private boolean isLeftPage() {
        return page % 2 == 1;
    }

    private boolean isAfter(final Page targetPage) {
        return page.compareTo(targetPage.getPage()) > 0;
    }

    private boolean isConnectedTo(final Page targetPage) {
        return Math.abs(page - targetPage.getPage()) == 1;
    }

    private Integer getPage() {
        return page;
    }

    public int findMaxValue() {
        List<Integer> digits = convertToDigits(page);

        return Math.max(calculateSum(digits), calculateMultiply(digits));
    }

    private List<Integer> convertToDigits(final Integer num) {
        List<Character> chars = convertToList(String.valueOf(num));

        return chars.stream()
            .map(Character::getNumericValue)
            .collect(Collectors.toUnmodifiableList());
    }

    private List<Character> convertToList(final String input) {
        List<Character> chars = new ArrayList<>();
        for (Character aChar : input.toCharArray()) {
            chars.add(aChar);
        }
        return chars;
    }

    private int calculateSum(final List<Integer> digits) {
        return digits.stream()
            .reduce(0, Integer::sum);
    }

    private int calculateMultiply(final List<Integer> digits) {
        return digits.stream()
            .reduce(1, (a, b) -> a * b);
    }
}
