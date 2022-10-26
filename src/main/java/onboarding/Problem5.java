package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        
        money = numberOfCurrency(money, 50000);
        
        return answer;
    }
    
    private static int numberOfCurrency(final int currentTotalMoney, final int monetaryUnit) {
        return currentTotalMoney / monetaryUnit;
    }
}
