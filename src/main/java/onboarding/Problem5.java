package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final int[] MONEY_CASE = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1} ;
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(Collections.emptyList());
        for(int moneyCase : MONEY_CASE){
            answer.add(getQuotient(money,moneyCase)) ;
            money = getRemainder(money, moneyCase) ;
        }
        return answer;
    }

    private static int getQuotient(int value, int moneyCase){
        return value/moneyCase ;
    }
    private static int getRemainder(int value, int moneyCase){
        return value%moneyCase ;
    }
}
