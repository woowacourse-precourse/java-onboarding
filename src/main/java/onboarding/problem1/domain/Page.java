package onboarding.problem1.domain;

import java.util.Objects;

public class Page {

    private final int left;
    private final int right;

    public Page(int left, int right) {
        if (isValidSequence(left, right)) {
            throw new IllegalArgumentException();
        }
        this.left = left;
        this.right = right;
    }

    private static boolean isValidSequence(int left, int right) {
        return (right - left) != 1;
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
