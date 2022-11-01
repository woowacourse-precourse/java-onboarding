package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static List<Integer> changeMoney(int money) {

        List<Integer> myMoneyList = new ArrayList<>();
        List<Integer> moneyType = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        for(int i = 0; i<moneyType.size(); i++) {
            if (i==0) {
                myMoneyList.add(money / moneyType.get(i));
            }
            else {
                myMoneyList.add((money % moneyType.get(i-1)) / moneyType.get(i));
            }
        }

        return myMoneyList;

    }
    public static List<Integer> solution(int money) {

        List<Integer> answer = changeMoney(money);
        return answer;

    }
}
