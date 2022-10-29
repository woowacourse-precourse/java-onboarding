package onboarding;

public class Problem3 {
    public static final int MAX_NUMBER = 10000;

    public static int solution(int number) {
        try {
            validateRange(number);
        } catch (IllegalArgumentException e) {
            return 0;
        }

        return countClaps(number);
    }

    public static void validateRange(int number) {
        if (number < 1 || number > MAX_NUMBER) {
            throw new IllegalArgumentException("유효하지 않은 범위 내의 숫자입니다.");
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
        if (digit == 3 || digit == 6 || digit == 9) {
            return 1;
        }

        return 0;
    }
}
