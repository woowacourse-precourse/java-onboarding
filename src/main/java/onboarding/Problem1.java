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

    static boolean exception(List<Integer> user) {
        if (user.get(1) - user.get(0) != 1) {
            return true;
        }
        return false;
    }



    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (exception(pobi) || exception(crong)) {
            return -1;
        }

        int pobiScore = 0;
        int crongScore = 0;

        for (Integer integer : pobi) {
            pobiScore = getMax(getSum(integer), getMul(integer));
        }

        for (Integer integer : crong) {
            crongScore = getMax(getSum(integer), getMul(integer));
        }

        int answer = compare(pobiScore, crongScore);
        return answer;
    }
}