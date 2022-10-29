package onboarding.problem1.domain;

import java.util.Arrays;
import java.util.Objects;

public class Page {

    private static final int PAGE_MIN = 1;
    private static final int PAGE_MAX = 400;
    private final int left;
    private final int right;

    public Page(int left, int right) {
        pageInputValidation(left, right);
        this.left = left;
        this.right = right;
    }

    private void pageInputValidation(int left, int right) {
        if (isValidSequence(left, right)) {
            throw new IllegalArgumentException();
        }
        if (isEscapePageBound(left, right)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isEscapePageBound(int left, int right) {
        return (left <= PAGE_MIN) || (right >= PAGE_MAX);
    }

    private static boolean isValidSequence(int left, int right) {
        return (right - left) != 1;
    }

    public int maxScore() {
        return Math.max(maxAddAndMultiplyEachDigit(left), maxAddAndMultiplyEachDigit(right));
    }

    public int maxAddAndMultiplyEachDigit(int number) {
        return Math.max(addEachDigit(number), multiplyEachDigit(number));
    }

    public int addEachDigit(int number) {
        return Arrays.stream(String.valueOf(number).split(""))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    public int multiplyEachDigit(int number) {
        return Arrays.stream(String.valueOf(number).split(""))
                .mapToInt(Integer::parseInt)
                .reduce(1, Math::multiplyExact);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Page page = (Page) o;
        return left == page.left && right == page.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
