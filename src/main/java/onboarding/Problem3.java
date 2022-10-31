package onboarding;

public class Problem3 {
    public static int countClap(int number) {
        int result = 0;

        while (number > 0) {
            if (number % 10 == 3 || number % 10 == 6 || number % 10 == 9) {
                result++;
            }
            number /= 10;
        }

        return result;
    }

    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += countClap(i);
        }

        return answer;
    }
}
