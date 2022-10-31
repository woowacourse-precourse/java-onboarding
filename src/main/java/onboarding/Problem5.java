package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        if (!isValidate(money)) {
            return Collections.emptyList();
        }

        int[] unit = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        List<Integer> answer = new ArrayList<>();
        getAnswer(money, unit, 0, answer);
        return answer;
    }

    /**
     * 제한사항 검증하는 기능
     */
    private static boolean isValidate(int money) {
        return (money > 0 && money < 1_000_001);
    }

    /**
     * 큰 돈 위주로 지갑에 담는 기능
     */
    private static void getAnswer(int money, int[] unit, int idx, List<Integer> answer) {
        if (idx == unit.length) {
            return;
        }
        answer.add(money / unit[idx]);
        getAnswer(money % unit[idx], unit, idx + 1, answer);
    }
}
