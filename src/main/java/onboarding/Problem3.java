package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        return answer;
    }

    // 1. 각 자리 수의 3, 6, 9 갯수를 반환하는 함수
    static int countClap(int num) {
        int cnt = 0;

        while(num > 0) {
            int digit = num % 10;
            if(digit % 3 == 0 && digit != 0) {
                cnt++;
            }
            num /= 10;
        }

        return cnt;
    }
}
