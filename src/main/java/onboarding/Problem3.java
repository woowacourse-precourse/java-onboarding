package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i <= number; i++) {
            answer += addClap(i);
        }

        return answer;
    }

    public static int addClap(int number) {
        int cnt = 0;

        while(number > 0) {
            cnt += count369(number % 10);
            number /= 10;
        }

        return cnt;
    }

    public static int count369(int num) {
        if(num != 0 && num % 3 == 0) {
            return 1;
        }

        return 0;
    }
}
