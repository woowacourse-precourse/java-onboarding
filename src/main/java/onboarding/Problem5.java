package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int unit1 = 50000;
        int unit2 = 10000;

        for (int count = 0; count < 4; count++) {
            answer.add(getCountByUnit(money, unit1));
            money %= unit1;
            answer.add(getCountByUnit(money, unit2));
            money %= unit2;

            unit1 /= 10;
            unit2 /= 10;
        }
        answer.add(money);

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
