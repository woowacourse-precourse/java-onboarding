package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i < number+1; i++) {
            int num = i;

            while (num > 0) {
                int mod = num % 10;
                if (mod != 0 && mod % 3 == 0) answer += 1;
                num /= 10;
            }
        }

        return answer;
    }
}
