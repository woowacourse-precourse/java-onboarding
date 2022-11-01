package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    /**
     * 1. 입력받은 돈의 액수를 가장 큰 금액을 시작으로 나누어 몫을 구한다.
     * 2. 남은 금액(mod)을 1번의 나머지 금액으로 갱신한다.
     * 3. 위 과정 반복
     */

    public static List<Integer> withDrawMoney(int money) {
        List<Integer> result = new ArrayList<Integer>();
        int[] currency = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int leftMoney = money;

        for (int value: currency) {
            result.add(leftMoney / value);
            leftMoney %= value;
        }
        return result;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = withDrawMoney(money);
        return answer;
    }
}
