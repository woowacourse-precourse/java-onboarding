package onboarding;

public class Problem3 {
    private static int checkThreeSixNine(int number) {
        if (number % 10 == 3 || number % 10 == 6 || number % 10 == 9) {
            return 1;
        }
        return 0;
    }
    private static int divideNumber(int number) {
        int count = 0;

        while (number > 0) {
            if (checkThreeSixNine(number) == 1) {
                count++;
            }
            number /= 10;
        }
        return count;
    }
    private static int checkNumber(int number) {
        if (number < 1 || number > 100) {
            return 0;
        }
        return 1;
    }
    public static int solution(int number) {
        if (checkNumber(number) == 0) {
            return -1;
        }
        int result = 0;

        for (int i = 1; i <= number; i++) {
            result += divideNumber(i);
        }
        return result;
    }
}
