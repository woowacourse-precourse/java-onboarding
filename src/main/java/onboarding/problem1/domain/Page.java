package onboarding.problem1.domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class Page {

    private final int left;
    private final int right;

    public Page(int left, int right) {
        PageValidator.pageInputValidation(left, right);
        this.left = left;
        this.right = right;
    }

    public int maxScore() {
        return Math.max(maxAddAndMultiplyEachDigit(left), maxAddAndMultiplyEachDigit(right));
    }

    public int maxAddAndMultiplyEachDigit(int number) {
        return Math.max(addEachDigit(number), multiplyEachDigit(number));
    }

    public int addEachDigit(int number) {
        return numberEachDigitIntStream(number)
                .sum();
    }

    public int multiplyEachDigit(int number) {
        return numberEachDigitIntStream(number)
                .reduce(1, Math::multiplyExact);
    }

    private static IntStream numberEachDigitIntStream(int number) {
        return Arrays.stream(String.valueOf(number).split(""))
                .mapToInt(Integer::parseInt);
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
