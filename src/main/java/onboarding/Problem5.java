package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        List<Integer> answer = new ArrayList<>();
        int[] moneyList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        // moneyList를 순회하면서 높은 금액부터 지불할 수 있는 단위 확인
        for (int i = 0; i < moneyList.length; i++) {

            // 몇 단위를 지불할 수 있는지 확인
            int cnt = howMuch(moneyList[i], money);
            answer.add(cnt);
            // 지불한 단위만큼의 금액을 money에서 차감
            money -= cnt * moneyList[i];
        }


        return answer;
    }

    public static int howMuch(int unit, int money) {
        return money / unit;
    }
}
