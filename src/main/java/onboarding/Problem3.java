package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++)
            answer += count369(i);
        return answer;
    }

    public static int count369(int num) {
        int cnt = 0;

        while (num > 0) {
            int n = num % 10;
            if (n == 3 || n == 6 || n == 9)
                cnt++;
            num /= 10;
        }
        return cnt;
    }
}
