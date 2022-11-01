

package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * moneyCount 메서드 돈을 50000부터 나누어 몫을 저장후 값을 차감하며 1까지 카운트를 List로 반환
 * isProperMoney 메서드 돈의 범위가 적절한지 확인
 */


public class Problem5 {

    private static final int MIN_MONEY = 1;
    private static final int MAX_MONEY = 1000000;
    final static int[] AMOUNT = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> count = new ArrayList<>();
        isProperMoney(money);
        return moneyCount(count, money);
    }

    private static void isProperMoney(int money) {
        if (money < MIN_MONEY || money > MAX_MONEY)
            throw new IllegalArgumentException("money는 1이상 1000000이하인 자연수입니다.");
    }

    private static List<Integer> moneyCount(List<Integer> count, int money) {
        for (int i = 0; i < AMOUNT.length; i++) {
            count.add(money / AMOUNT[i]);
            money %= AMOUNT[i];
        }
        return count;
    }
}