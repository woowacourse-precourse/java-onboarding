package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        // 1. 화폐단위마다 돈을 나눈 나머지를 구한다.
        int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int unit : units) {
            // 2. 몫이 존재하면 result에 몫을 추가한다.
            if (money >= unit) {
                answer.add(money / unit);
            } else {
                answer.add(0);
            }
            // 3.money에 나머지를 저장한다.
            money %= unit;
        }
        return answer;
    }
}
