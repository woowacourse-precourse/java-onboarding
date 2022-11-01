package onboarding;

public class Problem3 {
    private static int clap(int n) {
        int ret = 0;
        while(n > 0) {
            if((n % 10) > 0 && (n % 10) % 3 == 0) ret++;
            n /= 10;
        }
        return ret;
    }

    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i <= number; i++) answer += clap(i);
        return answer;
    }
}
