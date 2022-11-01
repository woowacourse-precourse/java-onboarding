package onboarding;

import java.util.*;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = getChange(money);
        return answer;
    }

    public static List<Integer> getChange(int money) {
        int[] divideAry = new int[] {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> res = new ArrayList<>();
        int holder = money, quotient = 0;

        for (int i = 0; i < divideAry.length; i++) {
            quotient = holder / divideAry[i];
            holder = holder % divideAry[i];
            res.add(quotient);
        }

        return res;
    }
}
