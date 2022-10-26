package onboarding;

/*
1. 손뼉 수 구하기
 */

public class Problem3 {

    private static int countClap(int number) {
        int tmp, sum = 0;
        for (int i = 1; i <= number; i ++) {
            tmp = i;
            while (tmp > 0) {
                if (tmp % 10 == 3 || tmp % 10 == 6 || tmp % 10 == 9)
                    sum++;
                tmp /= 10;
            }
        }
        return sum;
    }

    public static int solution(int number) {
        int answer = 0;
        answer = countClap(number);
        return answer;
    }
}
