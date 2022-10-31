package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    /**
     * 기능 구현
     * 1. 5만원권부터 1원 동전까지의 돈을 가지는 배열 생성
     * 2. 금액을 배열 값으로 나눈 결과값인 몫을 결과 배열에 담기
     */
    public static List<Integer> solution(int money) {
        List<Integer> answer = new java.util.ArrayList<>(Collections.emptyList());

        // 1.
        int[] bank = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        // 2.
        for (int i : bank) {
            answer.add(money / i);
            money %= i;
        }

        return answer;
    }
}
