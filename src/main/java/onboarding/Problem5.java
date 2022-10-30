package onboarding;

import java.util.ArrayList;
import java.util.List;

/* 기능 목록
 *
 * solution : 금액을 가장 적은 지폐/동전으로 나타낸 결과를 반환
 */
public class Problem5 {
    private static final List<Integer> moneySize = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        for(int m : moneySize) {
            answer.add(money / m);
            money %= m;
        }

        return answer;
    }
}
