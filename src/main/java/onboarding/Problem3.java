package onboarding;

public class Problem3 {
    private static int divideNumber(int number, int count) {
        return count;
    }
    public static int solution(int number) {
        int count = 0;
        int result = 0;

        for (int i = 1; i <= number; i++) {
            result += divideNumber(number, count);
        }

        return result;
    }
}
