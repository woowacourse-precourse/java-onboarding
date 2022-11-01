package onboarding;

public class Problem3 {
    public static int count(int number) {
        int cnt = 0;
        while (number != 0) {
            int n = number % 10;
            if (n == 3 || n == 6 || n == 9) {
                cnt++;
            }
            number /= 10;
        }
        return cnt;
    }

    public static int solution(int number) {
        int cnt = 0;
        for (int i = 1; i <= number; i++) {
            cnt += count(i);
        }
        return cnt;
    }
}