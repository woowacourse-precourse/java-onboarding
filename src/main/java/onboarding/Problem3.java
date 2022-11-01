package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return playGame(number);
    }

    private static int playGame(int number) {
        int cnt = 0;
        for (int i = 1; i <= number; i++) {
            cnt += countClap(i);
        }

        return cnt;
    }

    private static int countClap(int number) {
        int cnt = 0;

        while (number > 0) {
            int digit = number % 10;
            if (isThree(digit) || isSix(digit) || isNine(digit)) {
                cnt++;
            }
            number /= 10;
        }

        return cnt;
    }

    private static boolean isThree(int digit) {
        return digit == 3;
    }

    private static boolean isSix(int digit) {
        return digit == 6;
    }

    private static boolean isNine(int digit) {
        return digit == 9;
    }
}
