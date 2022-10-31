package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    private static final List<Integer> CASH_LIST = Arrays.asList(50000,10000,5000,1000,500,100,50,10,1);

    public static List<Integer> solution(int money) {
        List<Integer> answer = calculate(money);

        return answer;
    }

    public static List<Integer> calculate (int money) {
        List<Integer> cashCounts = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0));

        for (int i=0; i<CASH_LIST.size(); i++) {
            cashCounts.set(i,money/CASH_LIST.get(i));
            money = money%CASH_LIST.get(i);
        }
        return cashCounts;
    }

}
