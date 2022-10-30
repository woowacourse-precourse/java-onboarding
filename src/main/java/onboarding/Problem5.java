package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
            int[] units = {50000, 10000, 5000, 1000,500, 100, 50, 10, 1};
            int nowMoney = money;
            for (int unit : units) {
                if(money<unit) {
                    answer.add(0);
                    continue;
                }
                answer.add(getCount(nowMoney,unit));
            nowMoney = getRestMoney(nowMoney,unit);
        }
        return answer;
    }

    static int getCount(int money, int unit) {
        int result = 0;
        result = money / unit;
        return result;
    }

    static int getRestMoney(int money, int unit) {
        int result = 0;
        result = money % unit;
        return result;
    }
}
