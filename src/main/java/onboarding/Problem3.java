package onboarding;

public class Problem3 {
    private static int divideNumber(int number) {
        int count = 0;

        while (number > 0) {
            if (checkThreeSixNine(number) == 1) {
                count++;
            }
            number /= 10;
        }
        return count;
    }
    public static int solution(int number) {
        int result = 0;

        for (int i = 1; i <= number; i++) {
            result += divideNumber(i);
        }
        return result;
    }
}
