package onboarding;

import java.util.List;

class Problem1 {
    private final static int EXCEPTION = -1;
    private final static int SAME_SCORE = 0;
    private final static int POBI_WIN = 1;
    private final static int CRONG_WIN = 2;
    private final static int INPUT_SIZE = 2;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (validateLength(pobi) || validateRange(pobi) || validateSequence(pobi) || validateOddOrEven(pobi)) {
            return EXCEPTION;
        }
        if (validateLength(crong) || validateRange(crong) || validateSequence(crong) || validateOddOrEven(crong)) {
            return EXCEPTION;
        }

        int pobiScore = getMyScore(pobi);
        int crongScore = getMyScore(crong);

        if (pobiScore > crongScore) {
            return POBI_WIN;
        } else if (pobiScore < crongScore) {
            return CRONG_WIN;
        } else if (pobiScore == crongScore) {
            return SAME_SCORE;
        }
        return 0;
    }

    private static int getMyScore(List<Integer> player) {
        int result1 = getMaxScore(addAllNumbers(player.get(0)), multiplyAllNumbers(player.get(0)));
        int result2 = getMaxScore(addAllNumbers(player.get(0)), multiplyAllNumbers(player.get(0)));
        return getMaxScore(result1, result2);
    }

    private static int addAllNumbers(int number) {
        int result = 0;
        while (number > 0) {
            result += number % 10;
            number /= 10;
        }
        return result;
    }

    private static int multiplyAllNumbers(int number) {
        int result = 1;
        while (number > 0) {
            result *= number % 10;
            number /= 10;
        }
        return result;
    }

    private static int getMaxScore(int num1, int num2) {
        if (num1 > num2) {
            return num1;
        }
        return num2;
    }

    private static boolean validateLength(List<Integer> input) {
        return input.size() != INPUT_SIZE;
    }

    private static boolean validateRange(List<Integer> input) {
        return input.get(0) < 1 || input.get(1) > 400;
    }

    private static boolean validateSequence(List<Integer> input) {
        return input.get(1) - input.get(0) != 1;
    }

    private static boolean validateOddOrEven(List<Integer> input) {
        if (input.get(0) % 2 != 1) {
            return true;
        }
        if (input.get(1) % 2 != 0) {
            return true;
        }
        return false;
    }
}