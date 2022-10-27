package onboarding;

public class Problem3 {
    private static final int TARGET_NUMBER_THREE = 3;

    private static final int TARGET_NUMBER_SIX = 6;

    private static final int TARGET_NUMBER_NINE = 9;

    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; ++i) {
            answer += getThreeSixNineRecursive(i);
        }
        return answer;
    }

    private static int getThreeSixNineRecursive(int num) {
        if (num == 0) {
            return 0;
        }

        int value = num % 10;
        int result = 0;

        if (value == TARGET_NUMBER_THREE || value == TARGET_NUMBER_SIX || value == TARGET_NUMBER_NINE) {
            result = 1;
        }

        num /= 10;

        return result + getThreeSixNineRecursive(num);
    }
}
