package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** 구현 기능 목록
 * 1. 자연수 money를 단위별로 나누어 몫을 리스트에 저장하여 반환
 * */

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = exchangeMoney(money);
        return answer;
    }

    private static List<Integer> exchangeMoney(int money) {
        List<Integer> exchangedMoney = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0));
        List<Integer> moneyUnit = new ArrayList<>(Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));
        int i = 0;
        while(money > 0) {
            if (money >= moneyUnit.get(i)) {
                exchangedMoney.set(i, money / moneyUnit.get(i));
                money = money % moneyUnit.get(i);
            }
            i++;
        }
        return exchangedMoney;
    }
}
