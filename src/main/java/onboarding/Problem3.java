package onboarding;

public class Problem3 {

    public static final int START_NUMBER = 1;
    public static final int LAST_NUMBER = 10000;
    public static final int CHECK_RESTRICTIONS = -1;

    public static int solution(int number) {
        int answer = 0;

        if (!verificationCheck(number)) {
            return CHECK_RESTRICTIONS;
        }

        answer = startOneToNumber(number);

        return answer;
    }

    public static boolean verificationCheck(int number) {
        if (number < START_NUMBER || number > LAST_NUMBER) {
            return false;
        }
        return true;
    }

    public static int count(int targetNumber) {
        int result = 0;

        while (targetNumber > 0) {
            int nowNumber = targetNumber % 10;
            if (nowNumber == 3 || nowNumber == 6 || nowNumber == 9) {
                result++;
            }
            targetNumber /= 10;
        }

        return result;
    }

    public static int startOneToNumber(int number) {
        int total = 0;

        for (int i = START_NUMBER; i <= number; i++) {
            total += count(i);
        }

        return total;
    }
}
