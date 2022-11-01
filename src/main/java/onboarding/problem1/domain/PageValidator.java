package onboarding.problem1.domain;

public class PageValidator {

    private static final int PAGE_MIN = 1;
    private static final int PAGE_MAX = 400;

    public static void pageInputValidation(int left, int right) {
        if (isValidSequence(left, right)) {
            throw new IllegalArgumentException();
        }
        if (isEscapePageBound(left, right)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isEscapePageBound(int left, int right) {
        return (left <= PAGE_MIN) || (right >= PAGE_MAX);
    }

    private static boolean isValidSequence(int left, int right) {
        return (right - left) != 1;
    }

}
