package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        // 1. 단위가 되는 각 금액의 배열을 내림차순으로 구성
        int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> answer = new ArrayList<>(9); // 각 단위금액별 필요한 수

        // 2. 각 단위금액 별 필요한 수를 계산함
        for(int i=0 ; i<9 ; i++) {
            if(money/units[i] > 0) {
                answer.add(money / units[i]);
                money %= units[i];
            }
            else answer.add(0);
        }

        return answer;
    }
}
