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
            int digit = number % 10;

            if (isMultipleOfThree(digit)) {
                count++;
            }

            number /= 10;
        }

        return count;
    }

    private static boolean isMultipleOfThree(int digit) {
        return digit != 0 && digit % 3 == 0;
    }
}
