package onboarding;

public class Problem3 {
    public static int solution(int number) {
        if (number < 1 || 10000 < number) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i <= number; i++) {
            count += countClaps(i);
        }
        return count;
    }

    private static int countClaps(int number) {
        int count = 0;
        while (number >= 3) {
            count += (number % 10 == 3 || number % 10 == 6 || number % 10 == 9) ? 1 : 0;
            number /= 10;
        }
        return count;
    }
}
