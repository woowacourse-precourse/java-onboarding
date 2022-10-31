package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        /* 오만원으로 초기화 */
        int m = 50000;

        /* 짝수와 홀수기준으로 규칙 지정 구현 */
        for (int i = 0; i < 8; i++) {
            /* 짝수일때 */
            if (i % 2 == 0) {
                /* 현재 돈에서 m 나눈값 리스트에 추가 */
                answer.add(money / m);
                /* 현재 돈에서 m 나눈값에 m을 곱해서 현재 돈에 빼기 */
                money -= (money / m) * m;
                m /= 5;
            } else {
                answer.add(money / m);
                money -= (money / m) * m;
                m /= 2;
            }
        }

        /* 일원 동전 추가하기 (남은돈) */
        answer.add(money);

        return answer;
    }
}
