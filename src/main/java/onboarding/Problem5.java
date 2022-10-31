package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = calculation(money);
        return answer;
    }

    // 각 화폐가 얼마나 필요한지 계산하는 메서드
    static List<Integer> calculation(int money) {
        int[] unit = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < unit.length; i++) {
            int cnt = money / unit[i];
            if (money >= unit[i]) {
                money -= cnt * unit[i];
            }
            result.add(cnt);
        }

        return result;
    }
}
