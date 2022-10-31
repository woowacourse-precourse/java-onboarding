package onboarding;

public class Problem3 {
    static int AccumulateCount(int number) {
        int divisor = 10000;
        int count = 0;
        while (divisor > 0) {
            if ((int) (number / divisor) == 3 || (int) (number / divisor) == 6 || (int) (number / divisor) == 9) {
                count += 1;
            }
            number %= divisor;
            divisor /= 10;
        }
        return count;
    }

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
