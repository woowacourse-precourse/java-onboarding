package onboarding;

public class Problem3 {
    public static final int MAX_NUMBER = 10000;

    public static int solution(int number) {
        try {
            validateInputSize(number);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        return countClaps(number);
    }

    public static void validateInputSize(int number) {
        if (number < 1 || number > MAX_NUMBER) {
            throw new IllegalArgumentException("유효하지 않은 크기의 숫자입니다.");
        }
    }

    private static int countClaps(int end) {
        int claps = 0;

        for (int i = 1; i < end + 1; i++) {
            claps += countClapsForEachNumber(i);
        }

        return claps;
    }

    private static int countClapsForEachNumber(int number) {
        int numberCount = 0;

        while (number > 0) {
            numberCount += checkNumber(number % 10);
            number /= 10;
        }

        return numberCount;
    }

    private static int checkNumber(int digit) {
        if (isMultipleThree(digit)) {
            return 1;
        }

        return 0;
    }

    private static boolean isMultipleThree(int digit) {
        return (digit != 0 && digit % 3 == 0);
    }
}
