package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int cur = i;
            while (cur != 0) {
                if ((cur % 10) % 3 == 0 && cur % 10 != 0)
                    answer++;
                cur /= 10;
            }
        }
        return answer;
    }
}
