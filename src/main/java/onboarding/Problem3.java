package onboarding;

public class Problem3 {
    public static int solution(int n) {
        if(n<1||n>10000) return -1;
        int answer = 0;
        for (int i = 1; i <= n; i++) {
           answer+=getReturn(i);
        }
        return answer;
    }
    private static int getReturn(int num) {
        int answer = 0;
        while (num != 0) {
            if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9) {
                answer++;
            }
            num = num / 10;
        }

        return answer;
    }
}
