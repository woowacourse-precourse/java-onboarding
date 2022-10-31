package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        answer = convertMoney(money);

        return answer;
    }

    private static List<Integer> convertMoney(int money) {
        int[] exchangeMoneyArray = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int nowMoney = money;
        int getValue;
        List<Integer> result = new ArrayList<>();

        // 돈을 내림차순으로 환전하다.
        for(int exchangeMoney : exchangeMoneyArray) {
            getValue = getExchange(nowMoney, exchangeMoney);
            result.add(getValue);
            nowMoney -= exchangeMoney * getValue;
        }

        return result;
    }

    private static Integer getExchange(int money, int exchangeValue) {
        return money / exchangeValue;
    }
}
