package onboarding;

public class Problem3 {

    static int cnt;

    public static int solution(int number) {
        cnt = 0;
        for (int i = 1; i <= number; i++) {
            threeSixNine(i);
        }
        return cnt;
    }

    private static void threeSixNine(int i) {
        while (i != 0) {
            int digit = i % 10;
            if (digit == 3 || digit == 6 || digit == 9) {
                cnt++;
            }
            i /= 10;
        }
    }
}
