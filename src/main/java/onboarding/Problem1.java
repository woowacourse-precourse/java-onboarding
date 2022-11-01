package onboarding;

import java.util.List;
import java.util.stream.Collectors;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isInvalidPages(pobi) || isInvalidPages(crong)) {
            return -1;
        }

        int difference = calculateScore(pobi) - calculateScore(crong);
        if (difference > 0) {
            return 1;
        } else if (difference < 0) {
            return 2;
        } else {
            return 0;
        }
    }

    private static boolean isInvalidPages(List<Integer> pages) {
        boolean shouldPagesLengthEqualsTo2 = pages.size() == 2;
        boolean shouldPagesAreSequenced = pages.get(1) - pages.get(0) == 1;
        return !shouldPagesLengthEqualsTo2 || !shouldPagesAreSequenced;
    }

    private static int calculateScore(List<Integer> pages) {
        List<Integer> leftDigits = toDigits(pages.get(0));
        List<Integer> rightDigits = toDigits(pages.get(1));
        int leftScore = Math.max(sumOfDigits(leftDigits), multipleOfDigits(leftDigits));
        int rightScore = Math.max(sumOfDigits(rightDigits), multipleOfDigits(rightDigits));
        return Math.max(leftScore, rightScore);
    }

    private static List<Integer> toDigits(Integer number) {
        return number.toString().chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }

    private static int sumOfDigits(List<Integer> digits) {
        return digits.stream().reduce(0, Integer::sum);
    }

    private static int multipleOfDigits(List<Integer> digits) {
        return digits.stream().reduce(1, (a, b) -> a * b);
    }
}