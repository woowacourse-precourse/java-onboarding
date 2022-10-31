package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private static List<Integer> resultMoney;
    public static List<Integer> solution(int money) {
        resultMoney = new ArrayList<>(); // static 배열 초기화
        if(isValid(money)){
           countMoney(money);
           return resultMoney;
        }else
            return null;
    }

    public static void countMoney(int money) {
        // 큰 화폐부터 금액 할당하기
        Integer[] moneyList = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 };
        for (int m : moneyList) {
            resultMoney.add(money / m);
            money %= m;
        }

    }

    static boolean isValid(int money) {
        return money >= 1 && money <= 1000000;
    }
}
