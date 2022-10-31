package onboarding;

import java.util.*;

/**
 * 기능목록 <br>
 * 1. 가장 큰 위주의 돈을 담았을 경우의 리스트 반환
 */

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> availableMoney = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        availableMoney.sort(Collections.reverseOrder());//큰 값부터 계산한다.

        for (int i = 0; i < availableMoney.size(); i++) {
            answer.add(i, 0);
            if (money >= availableMoney.get(i)) {
                answer.set(i, money / availableMoney.get(i));
                money %= availableMoney.get(i);
            }
        }
        return answer;
    }
}
