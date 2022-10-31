package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        Problem5 pb5 = new Problem5();
        List<Integer> moneyList = pb5.getMoneyList();
        return pb5.getNumberOfMoney(money, moneyList);
    }

    public List<Integer> getMoneyList () {
        return List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
    }

    public List<Integer> getNumberOfMoney (int money, List<Integer> moneyList) {
        List<Integer> answer = new ArrayList<>();
        for(int coin : moneyList) {
            int numberOfMoney= money / coin;
            answer.add(numberOfMoney);
            money = money % coin;
        }
        return answer;
    }
}
