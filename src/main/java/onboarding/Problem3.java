package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=1; i<=number; i++)
            answer += count(i);
        return answer;
    }

    private static int count(int num) {
        int cnt = 0;
        while(num != 0) {
            if((num % 10) == 3 || (num % 10) == 6 || (num % 10) == 9) cnt++;
            num /= 10;
        }
        return cnt;
    }
}
