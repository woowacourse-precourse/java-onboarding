package onboarding;

public class Problem3 {
    private static int count(int n) {
        int cnt = 0;

        while(n > 0) {
            int digit = n % 10;

            if(digit != 0 && digit % 3 == 0)
                cnt++;

            n /= 10;
        }

        return cnt;
    }
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i <= number; i++)
            answer += count(i);

        return answer;
    }
}
