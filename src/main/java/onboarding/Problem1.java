package onboarding;

import java.util.List;

class Problem1 {

    static int getSum(int a) {

        int ans = 0;

        while (a > 0) {
            ans += a%10;
            a /= 10;
        }

        return ans;
    }

    static int getMul(int a) {

        int ans = 1;

        while (a > 0) {
            ans *= a%10;
            a /= 10;
        }

        return ans;

    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiScore = 0;
        int crongScore = 0;





        int answer = Integer.MAX_VALUE;
        return answer;
    }
}