package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    static int moneyUnitList[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer =getResultArray(money);
        return answer;
    }

    // 1. 총 금액이 각각의 돈 단위마다 몇 개씩 변환되는 지 구하기
    public static List<Integer> getResultArray(int money) {
        List<Integer> answer = new ArrayList<>(moneyUnitList.length);

        int moneyLeft = money;
        for (Integer moneyUnit :moneyUnitList) {
            answer.add(getShare(moneyLeft, moneyUnit));
            moneyLeft =getLeftMoney(moneyLeft, moneyUnit);
        }
        return answer;
    }

    // 2. (총 금액 / 돈 단위)의 몫 반환하기
    public static int getShare(int money, int moneyUnit) {
        return money / moneyUnit;
    }

    // 3. 현재 돈 단위를 제외한 나머지 금액 구하기
    public static int getLeftMoney(int money, int moneyUnit) {
        return money % moneyUnit;
    }
}
