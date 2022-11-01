package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    // 1. 금액이 큰 순서대로 화폐 개수를 구해서 반환한다.
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        Integer[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for(int i = 0; i < unit.length; i++){
            int n = (Integer)(money/unit[i]);
            answer.add(i, n);
            money -= n * unit[i];
        }
        return answer;
    }
}
