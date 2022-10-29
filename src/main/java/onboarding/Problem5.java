package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final int[] UNITS = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static int countMoneyPerUnit(int money, int unit){
        return money / unit;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        for(int i = 0; i < UNITS.length; i++){
            int count = countMoneyPerUnit(money, UNITS[i]);
            answer.add(count);
        }
        return answer;
    }
}
