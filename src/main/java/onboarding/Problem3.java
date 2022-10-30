package onboarding;

/*
1. 손뼉 수 구하기
 */

public class Problem3 {

    private static int getSumClap(int number) {
        int sumClap = 0;
        for (int i = 1; i <= number; i ++) {
            int element = i;
            while (element > 0) {
                if (element % 10 == 3 || element % 10 == 6 || element % 10 == 9)
                    sumClap++;
                element /= 10;
            }
        }
        return sumClap;
    }

    public static int solution(int number) {
        int answer = getSumClap(number);
        return answer;
    }
}
