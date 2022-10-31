package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {

    /**
     * 기능 목록
     * 1. 큰 단위로 화폐 교환
     */

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        // 돈 단위
        List<Integer> moneyUnit = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        // 1. 큰 단위 순서대로 돈을 나눠준 후, 결과 값에 추가
        for (Integer i : moneyUnit) {
            answer.add(money / i);
            money %= i;
        }

        return answer;
    }
}
