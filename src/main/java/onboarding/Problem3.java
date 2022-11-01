package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int k = i;
            while (k > 0) {
                int digit = k % 10;
                if (digit == 3 || digit == 6 || digit == 9) {
                    answer++;
                }
                k /= 10;
            }
        }
        return answer;
    }

}
