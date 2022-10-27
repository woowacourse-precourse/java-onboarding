package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static int check369(int digit) {
        if (digit == 3) return 1;
        if (digit == 6) return 1;
        if (digit == 9) return 1;

        return 0;
    }

    private static int count369(int number) {
        int count369 = 0;
        int digit = 0;
        while (number > 0) {
            digit = number % 10;
            count369 += check369(digit);
            number /= 10;
        }
        return count369;
    }
}
