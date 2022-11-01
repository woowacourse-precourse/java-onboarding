package onboarding;

public class Problem3 {
    public static int solution(int number) {
        // 2. 1부터 number까지 손뼉 갯수를 더하는 반복문 구현
        int cnt = 0;
        for(int i = 1; i <= number; i++) {
            cnt += countClap(i);
        }
        return cnt;
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
