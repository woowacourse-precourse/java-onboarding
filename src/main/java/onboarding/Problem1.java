package onboarding;

import org.junit.jupiter.api.Nested;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (Validator.notValidateNumbers(pobi) || Validator.notValidateNumbers(crong))
            return -1;
        return getGameResult(getHigherPoint((pobi)), getHigherPoint(crong));
    }

    private static int getGameResult(int left, int right) {
        if (left > right)
            return 1;
        if (left < right)
            return 2;
        return 0;
    }

    private static int getHigherPoint(List<Integer> numbers) {
        return Math.max(makeBiggestPoint(numbers.get(0)), makeBiggestPoint(numbers.get(1)));
    }

    private static int makeBiggestPoint(int number) {
        return Math.max(getAddEachOfDigits(number), getMultipleEachOfDigits(number));
    }

    private static int getAddEachOfDigits(int number) {
        int digits = getNumberOfDigits(number);
        int result = 0;
        for (int i = 0; i < digits; i++) {
            result += number % 10;
            number /= 10;
        }
        return result;
    }

    private static int getMultipleEachOfDigits(int number) {
        int digits = getNumberOfDigits(number);
        int result = 1;
        for (int i = 0; i < digits; i++) {
            result *= number % 10;
            number /= 10;
        }
        return result;
    }

    private static int getNumberOfDigits(int number) {
        if (number >= 100)
            return 3;
        if (number >= 10)
            return 2;
        return 1;
    }

    static class Validator {

        private static final int AVAILABLE_FIRST_PAGE = 3;
        private static final int AVAILABLE_LAST_PAGE = 398;
        public static boolean notValidateNumbers(List<Integer> numbers) {
            if (notTwoSizes(numbers))
                return true;
            if (notConsecutive(numbers))
                return true;
            if (notInSpecificRange(numbers))
                return true;
            if (notOddNumberOfLeft(numbers))
                return true;
            return false;
        }

        private static boolean notConsecutive(List<Integer> numbers) {
            return (numbers.get(1) - numbers.get(0)) != 1;
        }

        private static boolean notTwoSizes(List<Integer> numbers) {
            return numbers.size() != 2;
        }

        private static boolean notInSpecificRange(List<Integer> numbers) {
            return numbers.get(0) < AVAILABLE_FIRST_PAGE
                    || numbers.get(1) > AVAILABLE_LAST_PAGE;
        }

        private static boolean notOddNumberOfLeft(List<Integer> numbers) {
            return numbers.get(0) % 2 != 1;
        }
    }
}