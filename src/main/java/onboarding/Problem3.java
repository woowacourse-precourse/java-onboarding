package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int check_num = i;
            while (check_num != 0) {
                int digit = check_num % 10;
                if (digit == 3 || digit == 6 || digit == 9) {
                    answer++;
                }
                check_num /= 10;
            }
        }
        return answer;
    }
}
