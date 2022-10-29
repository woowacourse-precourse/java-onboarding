package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    private static void setMoneyCnt(List<Integer> moneyCnt, int money, int unit) {
        moneyCnt.add(money / unit);
    }

    private static int getChange(int money, int unit) {
        return money % unit;
    }
}
