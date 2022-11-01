package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += calculateClapCount(i);
        }
        return answer;
    }

    private static int calculateClapCount(int number) {
        int count = 0;
        while (number > 0) {
            if (shouldClap(number % 10)) {
                count++;
            }
            number /= 10;
        }
        return count;
    }

    private static boolean shouldClap(int digit) {
        return digit == 3 || digit == 6 || digit == 9;
    }
}