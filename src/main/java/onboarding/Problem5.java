package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * 기능 목록
 * 1. 현재 돈이 0원 보다 큰지 검증
 * 2. 현재 돈이 현재 거스름돈보다 큰지 검증
 * 3. 거슬러 주는 화폐 갯수 반환
 * 4. 잔돈 갱신
 * 5. answer에 화폐 갯수 결과 추가
 */
public class Problem5 {
    static final int[] CHANGES_VALUE = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        // Collections.emptyList();
        List<Integer> answer = new ArrayList<>();
        int idx = 0;
        while (hasEnoughMoney(money)) {
            int changes = 0;
            if (isMoneyBiggerThanChange(money, idx)) {
                changes = money / CHANGES_VALUE[idx];
                money -= changes * CHANGES_VALUE[idx];
            }
            answer.add(changes);
            idx++;
        }

        return answer;
    }

    static boolean hasEnoughMoney(int money) {
        return money > 0;
    }

    static boolean isMoneyBiggerThanChange(int money, int idx) {
        return money >= CHANGES_VALUE[idx];
    }
}
