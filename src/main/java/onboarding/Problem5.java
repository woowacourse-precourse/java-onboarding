package onboarding;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    /*
     * 금액이 주어졌을 때 최소한의 화폐 개수를 구하여 반환
     */
    public static void withdraw(int money, List<Integer> moneyUnitCountList) {
        int[] moneyUnitList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int moneyUnit : moneyUnitList) {
            money = countMonetaryUnit(money, moneyUnit,
                moneyUnitCountList);
        }
    }

    /*
     * 금액과 금액 단위가 주어졌을 때, 화폐 단위에 따른 개수 계산과 남은 금액을 계산하는 함수
     */
    public static int countMonetaryUnit(int money, int moneyUnit,
        List<Integer> moneyUnitList) {
        moneyUnitList.add(money / moneyUnit);
        int retainMoney = money % moneyUnit;
        return retainMoney;
    }
}
