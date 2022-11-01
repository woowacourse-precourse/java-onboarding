package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i=1; i<=number; i++) {
            answer += three_cnt(i);
        }

        return answer;
    }
    public static int three_cnt(int n) {
        int cnt = 0;
        while (n>0) {
            int rem = n%10;
            if (rem != 0 && rem%3==0) cnt++;
            n/=10;
        }
        return cnt;
    }
}
