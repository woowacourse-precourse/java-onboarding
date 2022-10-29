package onboarding;

public class Problem3 {
    static int countClap(int num) {
        int cnt = 0;
        int q = 0;
        while(num != 0) {
            q = num % 10;
            if(q != 0 && q % 3 == 0) {
                cnt++;
            }
            num /= 10;
        }
        return cnt;
    }
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
