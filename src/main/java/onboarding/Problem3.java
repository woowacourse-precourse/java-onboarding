package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += count369(i);
        }
        return answer;
    }

    public static int count369(int n) {
        int cnt = 0;
        while (n > 0) {
            if (n % 10 == 3 || n % 10 == 6 || n % 10 == 9) cnt += 1;
            n /= 10;
        }
        return cnt;
    }
}
