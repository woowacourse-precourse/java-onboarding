package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += get369Count(i);
        }

        return answer;
    }

    public static int get369Count(int n) {
        int cnt = 0;
        while (n > 0) {
            if ((n % 10 != 0) && (n % 10) % 3 == 0) cnt++;
            n /= 10;
        }
        return cnt;
    }
}
