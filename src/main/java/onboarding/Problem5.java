package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> moneyUnits = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        for (int moneyUnit : moneyUnits) {
            answer.add(getCountByUnit(money, moneyUnit));
            money %= moneyUnit;
        }

        return answer;
    }

    /*
    * 주어진 돈이 주어진 단위 몇 개로 변환되는지 반환
    *
    * @return int
    * */
    private static int getCountByUnit(int money, int unit) {
        if (money < unit) {
            return 0;
        }
        return money / unit;
    }
}
