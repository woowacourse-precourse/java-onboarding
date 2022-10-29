package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
기능 구현 사항
## 문제는 greedy algorithm 으로 해결한다.
1. monetary list 의 단위별로 금액을 나누어 해결한다.
*/

public class Problem5 {
    static int[] monetary_list = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        return sortingMoney(money);
    }

    public static List<Integer> sortingMoney(int money) {
        int index = 0;
        List<Integer> result = new ArrayList<>(Collections.nCopies(9, 0));
        while (money > 0) {
            if (money / monetary_list[index] == 0) {
                index++;
            } else {
                result.set(index, money / monetary_list[index]);
                money %= monetary_list[index];
            }
        }
        return result;
    }
}
