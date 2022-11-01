package onboarding;

public class Problem3 {
    public static int solution(int number) {

        int answer = 0;
        for (int i = 0; i < number + 1; i++) {
            int num = i;
            while (num != 0) {
                int res = num % 10;
                num /= 10;
                if (res == 3 || res == 6 || res == 9) {
                    answer += 1;
                }
            }
        }
        return answer;
    }
}
