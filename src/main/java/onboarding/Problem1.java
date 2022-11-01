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

    static int getMax(int a, int b) {

        if (a > b) {
            return a;
        }
        else{
            return b;
        }
    }

    static int compare(int a, int b) {
        if (a > b) {
            return 1;
        }
        else if (a < b) {
            return 2;
        }
        else {
            return 0;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiScore = 0;
        int crongScore = 0;





        int answer = Integer.MAX_VALUE;
        return answer;
    }
}