package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] currency = {50000,10000,5000,1000,500,100,50,10,1};
        for (int i = 0; i < currency.length; i++) {
            int numberOfMoney =calculateNumberOfMoney(money, currency[i]);
            money =calculateChange(money, currency[i]);
            answer.add(numberOfMoney);
        }
        return answer;
    }

    private static int calculateNumberOfMoney(int money, int currency) {
        int numberOfMoney = money / currency;
        return numberOfMoney;
    }

    private static int calculateChange(int money, int currency) {
        int change = money % currency;
        return change;
    }
}
