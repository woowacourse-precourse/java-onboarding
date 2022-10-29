package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        if (checkValidation(money)) {
            answer = convertMoney(money);
        }

        return answer;
    }

    private static boolean checkValidation(int inputValue) {
        // 1 이상 1,000,000 이하의 자연수인지 확인하다.
        if (!(1 <= inputValue && inputValue <= 1_000_000)) {
            return false;
        }

        return true;
    }

    private static List<Integer> convertMoney(int money) {
        int nowMoney = money;
        int getValue;
        List<Integer> result = new ArrayList<>();

        // 50,000원 지폐로 환전하다.
        getValue = getExchange(nowMoney, 50000);
        result.add(getValue);
        nowMoney -= 50000 * getValue;

        // 10,000원 지폐로 환전하다.
        getValue = getExchange(nowMoney, 10000);
        result.add(getValue);
        nowMoney -= 10000 * getValue;

        // 5,000원 지폐로 환전하다.
        getValue = getExchange(nowMoney, 5000);
        result.add(getValue);
        nowMoney -= 5000 * getValue;

        // 1,000원 지폐로 환전하다.
        getValue = getExchange(nowMoney, 1000);
        result.add(getValue);
        nowMoney -= 1000 * getValue;

        // 500원 동전으로 환전하다.
        getValue = getExchange(nowMoney, 500);
        result.add(getValue);
        nowMoney -= 500 * getValue;

        // 100원 동전으로 환전하다.
        getValue = getExchange(nowMoney, 100);
        result.add(getValue);
        nowMoney -= 100 * getValue;

        // 50원 동전으로 환전하다.
        getValue = getExchange(nowMoney, 50);
        result.add(getValue);
        nowMoney -= 50 * getValue;

        // 10원 동전으로 환전하다.
        getValue = getExchange(nowMoney, 10);
        result.add(getValue);
        nowMoney -= 10 * getValue;

        // 1원 동전으로 환전하다.
        result.add(nowMoney);

        return result;
    }

    private static Integer getExchange(int money, int exchangeValue) {
        return money / exchangeValue;
    }
}
