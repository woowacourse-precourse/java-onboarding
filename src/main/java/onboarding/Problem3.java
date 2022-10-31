package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int cnt = 0;
        for (int i = 1; i <= number; i++) {
            int cur = i;
            while (cur != 0) {
                int rest = cur % 10;
                if (rest == 3 || rest == 6 || rest == 9) {
                    cnt++;
                }
                cur /= 10;
            }
        }
        return cnt;
    }
}
