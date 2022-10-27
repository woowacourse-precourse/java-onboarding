package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int num = i;
            while (num > 0) {
                int left = num % 10;
                if (left == 3 || left == 6 || left == 9) {
                    answer += 1;
                }
                num /= 10;
            }
        }

        return answer;
    }
}
