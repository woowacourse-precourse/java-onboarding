package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final List<Integer> UNITS_OF_MONEY = unitsOfMoneyInit();
    
    private static List<Integer> unitsOfMoneyInit() {
        return List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
    }
    
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
    
        addNumberOfMonetaryUnits(money, answer);
    
        return answer;
    }
    
    private static void addNumberOfMonetaryUnits(int money, final List<Integer> answer) {
        for (Integer monetaryUnit : UNITS_OF_MONEY) {
            answer.add(numberOfCurrency(money, monetaryUnit));
            money = returnSmallChange(money, monetaryUnit);
        }
    }
    
    private static int returnSmallChange(int money, final Integer monetaryUnit) {
        return money % monetaryUnit;
    }
    
    private static int numberOfCurrency(final int currentTotalMoney, final int monetaryUnit) {
        return currentTotalMoney / monetaryUnit;
    }
}
