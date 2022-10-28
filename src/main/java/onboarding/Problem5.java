package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] moneyUnits = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int currMoney = money;

        for(int i = 0; i < moneyUnits.length; i++) {
            int numOfCurrUnit = currMoney / moneyUnits[i];
            answer.add(numOfCurrUnit);
            currMoney -= numOfCurrUnit * moneyUnits[i];
        }
        return answer;
    }
}
