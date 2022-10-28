package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        withdraw(money, answer);

        return answer;
    }

    // 큰 큼액의 화폐를 우선으로 출금하는 기능
    public static void withdraw (int money, List<Integer> answer) {
        int[] unitSet = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int unit : unitSet) {
            answer.add(money / unit);
            money = money % unit;
        }
    }
}
