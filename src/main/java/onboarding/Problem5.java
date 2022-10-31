package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = getMoneyType(money);
        return answer;
    }

    private static List<Integer> getMoneyType(int money) {
        int[] moneyType = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> numberOfMoneyType = new ArrayList<>();

        for(int i = 0; i < moneyType.length; i++) {
            numberOfMoneyType.add(money / moneyType[i]);
            money = money - numberOfMoneyType.get(i) * moneyType[i];
        }
        
        return numberOfMoneyType;
    }
}
