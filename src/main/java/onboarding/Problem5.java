package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 기능 목록
1. 화폐 단위 배열에 저장
2. 배열 순회하며 개수 계산
 */

public class Problem5 {
    public static List<Integer> solution(int money) {
        //List<Integer> answer = Collections.emptyList();
        List<Integer> answer = new ArrayList<Integer>();
        int[] units = {50_000, 10_000, 5000, 1000, 500, 100, 50, 10, 1};
        for(int unit : units) {
            answer.add(money/unit);
            money %= unit;
        }
        return answer;
    }
}
