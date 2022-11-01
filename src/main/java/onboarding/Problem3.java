package onboarding;

public class Problem3 {
    private static final String MESSAGE = "잘못된 입력입니다.";

    public static int solution(int number) {

        if (!isInputValid(number)) {
            throw new IllegalArgumentException(MESSAGE);
        }

        return countClap(number);
    }

    private static boolean isInputValid(int number) {
        return number >= 1 && number <= 10000;
    }

    private static int countClap(int number) {
        int cnt = 0;
        int checkNumber;

        for (int i = 1; i <= number; i++) {
            int order = i;
            while (order != 0) {
                checkNumber = order % 10;
                if (checkNumber == 3 || checkNumber == 6 || checkNumber == 9) {
                    cnt++;
                }
                order /= 10;
            }
        }
        return cnt;
    }
}
