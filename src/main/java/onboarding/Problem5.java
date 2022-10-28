package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 기능 구현
 * 1. 배열 생성. 길이 9
 * 2. 거스름돈 알고리즘 구현
 * 3. 예외 처리
 */

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(List.of(50000,10000,5000,1000,500,100,50,10,1));
        int divisor = 0;

        if (1 <= money && money <= 1000_000){
            return Collections.emptyList();
        }

        for (int i = 0; i < 9; i++){
            divisor = answer.get(i);
            answer.set(i, money / divisor);
            money %= divisor;
        }

        return answer;
    }
}
