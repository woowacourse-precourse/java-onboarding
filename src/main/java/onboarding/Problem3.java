package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += countClaps(i);
        }
        return answer;
    }

    private static int countClaps(int number) {
        int claps = 0;
        while (number > 0) {
            int digit = number % 10;
            if (digit == 3 || digit == 6 || digit == 9) {
                claps++;
            }
            number /= 10;
        }
        return claps;
    }
}
