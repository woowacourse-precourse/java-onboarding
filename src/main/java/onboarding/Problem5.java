package onboarding;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem5 {
    /**
     * 지폐 단위만큼 몇 장이 필요한지 리턴하는 메서드이다.
     *
     * @param : int, 금액
     * @return : List<Integer>, 필요한 지폐의 장수를 담고 있는 리스트
     */
    public static List<Integer> solution(int money) {
        List<Integer> answer = getChange(money);
        return answer;
    }

    /**
     * 지폐 몇 장이 필요한지 계산하여 리턴하는 메서드이다.
     *
     * @param : int, 금액
     * @return : List<Integer>, 필요한 지폐의 장수를 담고 있는 리스트
     */
    public static List<Integer> getChange(int money) {
        List<Integer> answer = new LinkedList<>();
        int[] coins = new int[] {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int idx = 0, size = coins.length; idx < size; idx++) {
            answer.add(money / coins[idx]);
            money = money % coins[idx];
        }

        return answer;
    }
}
