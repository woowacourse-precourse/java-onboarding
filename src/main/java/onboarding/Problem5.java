package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        if(isValid(money)){
           return countMoney(money);
        }else
            return null;
    }

    public static List<Integer> countMoney(int money) {
        List<Integer> resultMoney = new ArrayList<>();
        // 큰 화폐부터 금액 할당하기
        Integer[] moneyList = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 };
        for (int m : moneyList) {
            resultMoney.add(money / m);
            money %= m;
        }
        return resultMoney;

    }

    static boolean isValid(int money) {
        return money >= 1 && money <= 1000000;
    }
}
