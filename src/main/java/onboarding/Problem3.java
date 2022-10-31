package onboarding;

public class Problem3 {
    public static int cnt(int number) {
        int cnt = 0;
        int n = Integer.MAX_VALUE; //각 자리 수 받을 변수
        while(number!=0) {
            n = number%10;
            number /= 10;
            if( n == 3 || n == 6 || n ==9) {
                cnt += 1;
            }
        }
        return cnt;
    }

    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += cnt(i);
        }
        return answer;
    }
}
