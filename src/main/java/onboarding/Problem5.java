package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] unitArr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for(int i = 0; i < unitArr.length; i++) {
            int[] res = countCurrency(money, unitArr[i]);
            answer.add(res[0]);
            money = res[1];
        }
        return answer;
    }

    static int[] countCurrency (int money, int unit) {
        int Count = money / unit;
        int Remainder = money % unit;
        return new int[]{Count, Remainder};
    }
}
