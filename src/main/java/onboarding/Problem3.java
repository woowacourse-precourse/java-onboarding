package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += countClap(i);
        }

        return answer;
    }

    //TODO: 손뼉 치는 횟수 최적화
    private static int countClap(int number) {
        int count = 0;

        while (number > 0) {
            int digit = number % 10;

            if (isDigitMultipleOfThree(digit)) {
                count++;
            }

            number /= 10;
        }

        return count;
    }

    private static boolean isDigitMultipleOfThree(int number) {
        return number != 0 && number % 3 == 0;
    }
}
