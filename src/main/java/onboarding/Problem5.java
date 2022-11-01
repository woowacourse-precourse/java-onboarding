package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    // 각 반환 하고 싶은 금액 배열 CHANGE_MONEY_LIST
    private static final int[] CHANGE_MONEY_LIST = {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};
    // 반환 금액 계산
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int changeCount = 0;
        // CHANGE_MONEY_LIST를 순차적으로 돌며 큰 금액부터 계산
        for (int i = 0; i < CHANGE_MONEY_LIST.length; i++) {
            while (money - CHANGE_MONEY_LIST[i] >= 0) {
                changeCount += 1;
                money -= CHANGE_MONEY_LIST[i];
            }
            answer.add(changeCount);
            changeCount = 0;
        }
        return answer;
    }
}
