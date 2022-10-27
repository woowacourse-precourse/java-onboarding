package onboarding;

public class Problem3 {
    public static int chckClap(int n) {
        int cnt = 0;

        while(n > 0) {
            if (n%10 != 0 && (n%10) % 3 == 0) {  // 3, 6, 9 모두 3의 배수임
                cnt++;
            }
            n /= 10;
        }

        return cnt;
    }

    public static int getAnswer(int n) {
        int cnt = 0;

        for(int i = 1; i <= n; i++) {
            cnt += chckClap(i);
        }

        return cnt;
    }

    public static int solution(int number) {
        int answer = 0;

        answer = getAnswer(number);

        return answer;
    }
}
