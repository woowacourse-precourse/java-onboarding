package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static List<Integer> moneyCounter(int money){
        int moneyRemainder = money;
        List<Integer> countMoney = new ArrayList<>();
        countMoney.add(moneyRemainder / 50000);
        moneyRemainder %= 50000;
        countMoney.add(moneyRemainder / 10000);
        moneyRemainder %= 10000;
        countMoney.add(moneyRemainder / 5000);
        moneyRemainder %= 5000;
        countMoney.add(moneyRemainder / 1000);
        moneyRemainder %= 1000;
        countMoney.add(moneyRemainder / 500);
        moneyRemainder %= 500;
        countMoney.add(moneyRemainder / 100);
        moneyRemainder %= 100;
        countMoney.add(moneyRemainder / 50);
        moneyRemainder %= 50;
        countMoney.add(moneyRemainder / 10);
        moneyRemainder %= 10;
        countMoney.add(moneyRemainder);
        return countMoney;
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(); //Collections.emptyList();
        answer.addAll(moneyCounter(money));
        return answer;
    }
}
