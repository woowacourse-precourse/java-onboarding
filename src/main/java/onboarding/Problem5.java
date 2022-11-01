package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = getMoneyList(money);
        return answer;
    }

    /**
     * 변환된 리스트/배열을 구하기
     * 
     * @param money
     * @return
     */
    private static List<Integer> getMoneyList(int money) {
        List<Integer> exchangeMoneyList = new ArrayList<Integer>();

        List<Integer> moneyUnitList = getMoneyUnitList();
        for (int i = 0; i < moneyUnitList.size(); i++) {
            int moneyUnit = moneyUnitList.get(i);
            for (int j = 1; j < Integer.MAX_VALUE; j++) {
                // 화폐단위를 곱하면서 원래 금액보다 커지면 정지한다.
                if (money < moneyUnit * j) {
                    exchangeMoneyList.add(j - 1);
                    money = money - moneyUnit * (j - 1);
                    break;
                }
            }
        }
        return exchangeMoneyList;
    }

    /**
     * 금액 단위 목록 구하기
     * 
     * @return
     */
    private static List<Integer> getMoneyUnitList() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(50000);
        list.add(10000);
        list.add(5000);
        list.add(1000);
        list.add(500);
        list.add(100);
        list.add(50);
        list.add(10);
        list.add(1);
        return list;
    }
}
