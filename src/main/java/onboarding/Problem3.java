package onboarding;

public class Problem3 {
    static int count(int n) {
        int cnt = 0;
        while (n > 0) {
            int first = n % 10;
            if (first == 3 || first == 6 || first == 9) {
                cnt++;
            }
            n /= 10;
        }
        return cnt;
    }

    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += count(i);
        }
        return answer;
    }
}
