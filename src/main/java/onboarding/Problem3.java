package onboarding;

public class Problem3 {
    private static final int NUMBER_THREE = 3;
    private static final int NUMBER_SIX = 6;
    private static final int NUMBER_NINE = 9;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 10000;

    public static int solution(int number) {
        validityChecker(number);

        return getClapNumber(number);
    }
    private static void validityChecker(int number) {
        if (isNotValidNumber(number))
            throw new IllegalArgumentException("Not valid number");
    }
    private static boolean isNotValidNumber(int number) {
        return number < MIN_NUMBER || MAX_NUMBER < number;
    }
    private static int getClapNumber(int number) {
        int clapNumber = 0;

        for (int i = 1; i <= number; i++) {
//            clapNumber += countClap(i);
        }
        return clapNumber;
    }
}