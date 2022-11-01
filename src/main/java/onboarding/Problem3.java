package onboarding;

public class Problem3 {
    public static int countNumber(int n) {
        int cnt = 0;
        while (n > 0) {
            int rest = n % 10;
            if (rest == 3 || rest == 6 || rest == 9)
                cnt++;
            n /= 10;
        }
        return cnt;
    }
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += countNumber(i);
        }
        return answer;
    }
}
