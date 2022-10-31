package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    // 문제에서 주어진 금액 단위
    public static int[] moneyList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    // 주어진 money를 moneyList의 값으로 차례대로 몫을 구하여 리스트에 추가
    public static List<Integer> getResultList(int money) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < moneyList.length; i++) {
            res.add(money / moneyList[i]);
            money %= moneyList[i];
        }

        return res;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = getResultList(money);

        return answer;
    }
}
