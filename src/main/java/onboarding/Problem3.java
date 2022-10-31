package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int tmp;
        for (int i = 1; i <= number; ++i) {
            tmp = i;
            while (tmp > 0) {
                if (tmp % 10 != 0 && (tmp % 10) % 3 == 0)
                    answer++;
                tmp /= 10;
            }
        }

        return answer;
    }
}
