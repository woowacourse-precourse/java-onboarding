package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    static int restMoney;
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    public static int countMoneyByUnit(int unit){
        int count = restMoney / unit;
        restMoney = restMoney % unit;
        return count;
    }
}
