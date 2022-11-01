package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        if (!isValidNumberRange(number)) {
            return -1;
        }

        for (int i = 1; i <= number; i++) {
            answer += getCount(i);
        }
        return answer;
    }

    private static int getCount(int number) {
        int count = 0;
        while (number != 0) {
            if ((number % 10) == 3 || (number % 10) == 6 || (number % 10) == 9) {
                count++;
            }
            number /= 10;
        }
        return count;
    }

    private static boolean isValidNumberRange(int number) {
        if (number < 1 || number > 10000) {
            return false;
        }
        return true;
    }
}
