package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
* 기능 목록
* 1. 금액 단위가 주어졌을 때 반환되는 동전 개수 구하기
* 2. 모든 단위별 동전 개수 구하기
* */
public class Problem5 {

    // 금액 단위가 주어졌을 때 반환되는 동전 개수 구하기
    public static int getMoneyCount(int money, int moneyUnit, List<Integer> answer) {
        answer.add(money / moneyUnit);
        // 남은 돈 리턴
        return money % moneyUnit;
    }
    // 모든 단위별 동전 개수 구하기
    public static List<Integer> getMoneyCountPerUnit(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> moneyUnitList = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        for (Integer moneyUnit : moneyUnitList) {
            money = getMoneyCount(money, moneyUnit, answer);
        }

        return answer;
    }

    public static List<Integer> solution(int money) {
        return getMoneyCountPerUnit(money);
    }
}
