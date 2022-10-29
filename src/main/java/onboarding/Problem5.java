package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

public class Problem5 {
    private static final int[] UNITS = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static int countMoneyPerUnit(int money, int unit){
        return money / unit;
    }

    public static int calculateMoneyToSubtract(int unit, int count){
        return unit * count;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = new LinkedList<Integer>();
        for(int unit : UNITS){
            int count = countMoneyPerUnit(money, unit);
            answer.add(count);
            money = money - calculateMoneyToSubtract(unit, count);
        }
        return answer;
    }
}
