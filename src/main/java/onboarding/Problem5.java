package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private static final List<Integer> CHANGE_UNITS =
            List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        addCountToAnswer(answer, money);

        return answer;
    }

    private static void addCountToAnswer(List<Integer> answer, int money) {
        for (int change : CHANGE_UNITS) {
            int count = money / change; // 거슬러지는 권종의 개수 ('/' 연산자는 나머지를 버리므로 예외는 없다.)
            answer.add(count);

            // 이미 거슬러진 금액을 제외하고 money 값을 갱신한다.
            money %= change;
        }
    }
}
